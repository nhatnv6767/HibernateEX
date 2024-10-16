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
                String hql = "from Cat c WHERE c.id=:id";
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

    public boolean saveOrUpdate(Cat cat) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

                // thuc thi cau lenh HQL

                // persist(): khong tra ve id, khong bao loi khi gap loi

                // chi luu khi chua ton tai
//                session.save(cat);
                // them moi khi chua ton tai, cap nhat du lieu khi da ton tai
                session.saveOrUpdate(cat);

                tr.commit();

                session.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean insert(Cat cat) {
        return saveOrUpdate(cat);
    }

    @Override
    public boolean update(Cat cat) {
        return saveOrUpdate(cat);
    }

    @Override
    public boolean delete(Cat cat) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

                // thuc thi cau lenh HQL
                // chi luu khi chua ton tai
//                session.save(cat);
                // them moi khi chua ton tai, cap nhat du lieu khi da ton tai
                session.delete(cat);

                tr.commit();

                session.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
