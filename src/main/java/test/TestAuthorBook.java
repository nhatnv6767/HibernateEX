package test;

import model.Author;
import model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.sql.Date;
import java.util.List;

public class TestAuthorBook {
    public static void main(String[] args) {
//        testAuthorBook();
        testAuthorBook2();
    }

    public static void testAuthorBook() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();

            Author author_1 = new Author("001", "Nguyen Nhat Anh", new Date(System.currentTimeMillis()));
            Book b1 = new Book("B01", "Toi thay hoa vang tren co xanh", 500, author_1);
            Book b2 = new Book("B02", "Toi muon random ra ten sach", 125, author_1);
            Book b3 = new Book("B03", "Dung thay hoa no khong", 40, author_1);

            session.saveOrUpdate(author_1);
            session.saveOrUpdate(b1);
            session.saveOrUpdate(b2);
            session.saveOrUpdate(b3);


            tr.commit();
            session.close();
        }
    }

    public static void testAuthorBook2() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();

            Author author_2 = new Author("002", "Nguyen Kim Cuong Anh", new Date(System.currentTimeMillis()));
            Book b3 = new Book("B03", "Random name 1", 123, author_2);
            Book b4 = new Book("B04", "Random name 2", 125, author_2);
            Book b5 = new Book("B05", "Random name 3", 40, author_2);

            session.saveOrUpdate(author_2);
            session.saveOrUpdate(b3);
            session.saveOrUpdate(b4);
            session.saveOrUpdate(b5);


            tr.commit();
            session.close();
        }
    }
}
