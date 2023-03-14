package dao;

public interface GenericDAO<T> {

    void saveOrUpdate(T object);
    T findById(Class clazz, Long id);
    void remove(T object);

}
