package dao;

import java.util.List;

public interface ItemDao<E> {
    public E findById(int id);
    public  List<E> getAll();
    public  void update(E entity);
    public  boolean delete(int id);
    public  void save(E entity);


}
