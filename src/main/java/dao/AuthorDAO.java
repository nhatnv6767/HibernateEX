package dao;

import model.Author;

import java.util.List;

public class AuthorDAO implements DAOInterface<Author> {
    @Override
    public List<Author> sellectAll() {
        return List.of();
    }

    @Override
    public Author selectById(Author author) {
        return null;
    }

    @Override
    public boolean insert(Author author) {
        return false;
    }

    @Override
    public boolean update(Author author) {
        return false;
    }

    @Override
    public boolean delete(Author author) {
        return false;
    }
}
