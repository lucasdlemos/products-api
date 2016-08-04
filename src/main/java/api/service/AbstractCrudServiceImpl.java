package api.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lucaslemos on 8/3/16.
 */
public abstract class AbstractCrudServiceImpl<T, R extends JpaRepository> implements AbstractCrudService<T> {

    protected final R repository;

    protected AbstractCrudServiceImpl(R repository) {
        this.repository = repository;
    }

    public T create(T entity) {
        return (T) repository.save(entity);
    }

    @Override
    public List<T> batchCreate(Iterable<T> entities) {
        return repository.save(entities);
    }

    @Override
    public T update(T entity) {
        return (T) repository.save(entity);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public void delete(Integer id) {
        repository.delete(id);
    }


}
