package test;

import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

public class TestCat {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    Cat cat1 = new Cat();
                    cat1.setName("Tom");
                    cat1.setSex(true);
                    session.save(cat1);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    session.close();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
