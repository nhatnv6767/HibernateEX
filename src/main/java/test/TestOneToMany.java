package test;

import model.Customer;
import model.Order;
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

            Customer c1 = new Customer("001", "Le Thanh Than", "Nhat@gmail.com");
            Order o1 = new Order("1", "TP.HCM", c1);
            Order o2 = new Order("2", "TP.HCM", c1);
            Order o3 = new Order("3", "TP.HCM", c1);
            Order o4 = new Order("4", "TP.HCM", c1);

            List<Order> list = new ArrayList<>();
            list.add(o1);
            list.add(o2);
            list.add(o3);
            list.add(o4);

            c1.setOrders(list);

            session.saveOrUpdate(c1);


            tr.commit();
            session.close();
        }
    }
}
