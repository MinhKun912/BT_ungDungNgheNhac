package service;

import java.util.List;

public interface IService<T> {
    List<T>findAll();
    T findBy0Id(int id);
    void deleteByID(int id);
    void save(T t);
}
