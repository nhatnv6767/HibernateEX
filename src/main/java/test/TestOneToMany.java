package test;

import model.Customer;
import model.My_Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class TestOneToMany {
    public static void main(String[] args) {
        testOneTomany();
    }

    public static void testOneTomany() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();

//            Customer c1 = new Customer("001", "Le Thanh Than", "Nhat@gmail.com");
//            My_Order o1 = new My_Order("1", "TP.HCM", c1);
//            My_Order o2 = new My_Order("2", "TP.HCM", c1);
//            My_Order o3 = new My_Order("3", "TP.HCM", c1);
//            My_Order o4 = new My_Order("4", "TP.HCM", c1);
//
//            List<My_Order> list = new ArrayList<>();
//            list.add(o1);
//            list.add(o2);
//            list.add(o3);
//            list.add(o4);
//
//            c1.setOrders(list);
//
//            session.saveOrUpdate(c1);
//            session.saveOrUpdate(o1);
//            session.saveOrUpdate(o2);
//            session.saveOrUpdate(o3);
//            session.saveOrUpdate(o4);
//
//            Customer c2 = new Customer("002", "Le Thanh Than 2", "Nhat2@gmail.com");
//            session.saveOrUpdate(c2);

            String hql = "FROM Customer c where size(c.orders) > 0";
            List<Customer> results = session.createQuery(hql).list();

            for (Customer c : results) {
                System.out.println(c.toString());
            }


            tr.commit();
            session.close();
        }
    }
}
