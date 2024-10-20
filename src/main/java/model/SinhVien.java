package model;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class SinhVien extends ConNguoi {
    private double diemTrungBinh;

    public SinhVien() {
    }


    public SinhVien(String id, String hoVaTen, Date ngaySinh, double diemTrungBinh) {
        super(id, hoVaTen, ngaySinh);
        this.diemTrungBinh = diemTrungBinh;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }
}
