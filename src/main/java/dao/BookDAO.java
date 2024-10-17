package dao;

import model.Book;

import java.util.List;

public class BookDAO implements DAOInterface<Book> {
    @Override
    public List<Book> sellectAll() {
        return List.of();
    }

    @Override
    public Book selectById(Book book) {
        return null;
    }

    @Override
    public boolean insert(Book book) {
        return false;
    }

    @Override
    public boolean update(Book book) {
        return false;
    }

    @Override
    public boolean delete(Book book) {
        return false;
    }
}
