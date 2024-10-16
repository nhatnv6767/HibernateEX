package test;

import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.sql.Date;


public class TestCat2 {
    public static void main(String[] args) {
        Cat cat_2 = new Cat("Meo long xu", new Date(System.currentTimeMillis()), true);


        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

                // persistent
                session.save(cat_2);

                tr.commit();

                // Detached => Persistent
                session.refresh(cat_2);
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(cat_2);
    }
}
