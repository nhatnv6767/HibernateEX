package test;

import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();

            String hql = "SELECT p.id,  p.name,p.spouse.id, p.spouse.name FROM Person p";
            List<Object[]> results = session.createQuery(hql).list();

            for (Object[] rs : results) {
                String id = rs[0].toString();
                String name = rs[1].toString();
                String spouseId = rs[2].toString();
                String spouseName = rs[3].toString();
                System.out.println(id + " " + name + " married with " + spouseId + " " + spouseName);
            }


            tr.commit();
            session.close();
        }
    }
}
