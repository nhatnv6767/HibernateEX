package dao;

import java.util.List;

public interface DAOInterface<T> {
    List<T> sellectAll();

    T selectById(T t);

    boolean insert(T t);

    boolean update(T t);

    boolean delete(T t);

}
