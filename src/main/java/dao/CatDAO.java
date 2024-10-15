package dao;

import model.Cat;

import java.util.List;

public class CatDAO implements DAOInterface<Cat> {
    @Override
    public List<Cat> sellectAll() {
        return List.of();
    }

    @Override
    public Cat selectById(Cat cat) {
        return null;
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
