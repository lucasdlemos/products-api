package api.controller;

import api.service.AbstractCrudService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by lucaslemos on 8/3/16.
 */
public abstract class AbstractCrudController<T, S extends AbstractCrudService> {

    protected final S service;

    protected AbstractCrudController(S service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public T create(@RequestBody T entity) {
        return (T) service.create(entity);
    }

    @RequestMapping(value = "/batchCreate", method = RequestMethod.POST)
    public T batchCreate(@RequestBody List<T> entities) {
        return (T) service.batchCreate(entities);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public T update(@RequestBody T entity) {
        return (T) service.update(entity);
    }


    @RequestMapping("/findAll")
    public List<T> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
