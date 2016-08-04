package api.service;

import java.util.List;

/**
 * Created by lucaslemos on 8/3/16.
 */
public interface AbstractCrudService<T> {

    T create(T entity);
    List<T> batchCreate(Iterable<T> entities);
    T update(T entity);
    List<T> findAll();
    void delete(Integer id);

}
