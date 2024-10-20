package test;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneralTest {
    public static void main(String[] args) {
//        testManyToMany();
//        testInheritance();
//        testCascade();
        testLazyEager();
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
            ctdh2.setTenSanPham("Sau rieng");
            ctdh2.setGiaBan(7777);
            ctdh2.setSoLuong(50);
            ctdh2.setThanhTien(ctdh2.getSoLuong() * ctdh2.getGiaBan());
            ctdh2.setDonHang(dh1);

            dh1.addCTDH(ctdh1);
            dh1.addCTDH(ctdh2);

            session.saveOrUpdate(dh1);

//            DonHang dh = session.load(DonHang.class, 2);
//            session.remove(dh);

            tr.commit();
            session.close();
        }
    }

    public static void testLazyEager() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();

            DonHang dh1 = new DonHang();
            dh1.setTenKhachHang("Trần Tiểu Xuân");
            dh1.setNgayMua(new Date(123, 1, 30));

//            for (int i = 0; i < 10000; i++) {
//                Random rand = new Random();
//                ChiTietDonHang ctdh1 = new ChiTietDonHang();
//                ctdh1.setTenSanPham("Sản phẩm " + i + 1);
//                ctdh1.setGiaBan(rand.nextInt(90000));
//                ctdh1.setSoLuong(rand.nextInt(60));
//                ctdh1.setThanhTien(ctdh1.getGiaBan() * ctdh1.getSoLuong());
//                ctdh1.setDonHang(dh1);
//                dh1.addCTDH(ctdh1);
//            }
//
//
//            session.saveOrUpdate(dh1);

//            session.remove(dh);

            long batDau = System.currentTimeMillis();
            DonHang dh = session.load(DonHang.class, 3036);
            long ketThuc = System.currentTimeMillis();
            System.out.println(dh.toString());
            List<ChiTietDonHang> ds = dh.getDanhSachChiTiet();
            for (ChiTietDonHang ctdh : ds) {
                System.out.println(ctdh.toString());
            }
            System.out.println("Thoi gian thuc hien cau lenh la: " + (ketThuc - batDau));

            tr.commit();
            session.close();
        }
    }


}
