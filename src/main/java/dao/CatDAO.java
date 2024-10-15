package dao;

import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CatDAO implements DAOInterface<Cat> {
    @Override
    public List<Cat> sellectAll() {
        List<Cat> list = new ArrayList<>();

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

                // thuc thi cau lenh HQL
                String hql = "from Cat";
                Query query = session.createQuery(hql);
                list = query.getResultList();

                tr.commit();

                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Cat selectById(Cat cat) {
        List<Cat> list = new ArrayList<>();

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

                // thuc thi cau lenh HQL
                String hql = "from Cat c WHERE c.id:=id";
                Query query = session.createQuery(hql);
                query.setParameter("id", cat.getId());
                list = query.getResultList();

                tr.commit();

                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean insert(Cat cat) {
        return false;
    }

    @Override
    public boolean update(Cat cat) {
        return false;
    }

    @Override
    public boolean delete(Cat cat) {
        return false;
    }
}
