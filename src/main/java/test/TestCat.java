package test;

import dao.CatDAO;
import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class TestCat {
    public static void main(String[] args) {
        CatDAO cat_Dao = new CatDAO();

        List<Cat> list = cat_Dao.sellectAll();
        for (Cat c : list) {
            System.out.println(c);
        }

    }
}
