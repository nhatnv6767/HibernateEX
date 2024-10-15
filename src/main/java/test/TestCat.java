package test;

import dao.CatDAO;
import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.sql.Date;
import java.util.List;

public class TestCat {
    public static void main(String[] args) {
        CatDAO cat_Dao = new CatDAO();

//        List<Cat> list = cat_Dao.sellectAll();
//        for (Cat c : list) {
//            System.out.println(c);
//        }

        // select by id
//        Cat c = new Cat();
//        c.setId(2);
//        Cat c1 = cat_Dao.selectById(c);
//        System.out.println(c1);


        // test insert
        Cat c3 = new Cat("Meo 3", new Date(System.currentTimeMillis()), Boolean.valueOf(String.valueOf(1)));
        cat_Dao.insert(c3);

    }
}
