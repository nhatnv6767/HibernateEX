package test;

import model.CuocHop;
import model.Customer;
import model.NhanVien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.sql.Date;
import java.util.List;

public class GeneralTest {
    public static void main(String[] args) {
        testManyToMany();
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
}
