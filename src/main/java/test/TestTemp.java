package test;

import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.sql.Date;

public class TestTemp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();

            Person p1 = new Person("Binh", new Date(System.currentTimeMillis()), null);
            session.save(p1);

            tr.commit();
            session.close();
        }
    }
}
