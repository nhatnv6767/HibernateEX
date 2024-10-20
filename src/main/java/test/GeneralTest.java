package test;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.sql.Date;
import java.util.List;

public class GeneralTest {
    public static void main(String[] args) {
//        testManyToMany();
//        testInheritance();
        testCascade();
    }

    public static void testManyToMany() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();

            NhanVien nv1 = new NhanVien("NV1", "This is name", new Date(2000, 10, 15));
            NhanVien nv2 = new NhanVien("NV2", "This is name 2", new Date(2000, 10, 15));

//            session.saveOrUpdate(nv1);
            CuocHop ch1 = new CuocHop();
            ch1.setTenCuocHop("Hop hoi dong quan tri cong ty");
            ch1.setThoiGian(new Date(2025, 2, 27));
            ch1.setDiaDiem("Phong hop 1");
            ch1.addNhanVien(nv1);

            session.saveOrUpdate(ch1);

            tr.commit();
            session.close();
        }
    }

    public static void testInheritance() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();

            GiaoVien gv = new GiaoVien("GV01", "Tran Thi Thanh Hien", new Date(100, 1, 30), "Hibernate");
            SinhVien sv = new SinhVien("072234", "Sinh vien 1", new Date(105, 2, 15), 9.8);

            session.saveOrUpdate(gv);
            session.saveOrUpdate(sv);


            tr.commit();
            session.close();
        }
    }

    public static void testCascade() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();

            DonHang dh1 = new DonHang();
            dh1.setTenKhachHang("Le bao lam");
            dh1.setNgayMua(new Date(123, 1, 30));

            ChiTietDonHang ctdh1 = new ChiTietDonHang();
            ctdh1.setTenSanPham("Mi tom Hao Hao");
            ctdh1.setGiaBan(5000);
            ctdh1.setSoLuong(5);
            ctdh1.setThanhTien(5 * 5000);
            ctdh1.setDonHang(dh1);

            ChiTietDonHang ctdh2 = new ChiTietDonHang();
            ctdh1.setTenSanPham("Sau rieng");
            ctdh1.setGiaBan(7000);
            ctdh1.setSoLuong(50);
            ctdh1.setThanhTien(50 * 7000);
            ctdh1.setDonHang(dh1);

            dh1.addCTDH(ctdh1);
            dh1.addCTDH(ctdh2);

            session.saveOrUpdate(dh1);
            

            tr.commit();
            session.close();
        }
    }


}
