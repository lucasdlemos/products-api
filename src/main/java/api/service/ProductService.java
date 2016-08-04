package api.service;

import api.domain.Product;

/**
 * Created by lucaslemos on 8/3/16.
 */
public interface ProductService extends AbstractCrudService<Product> {

    Product findByName(String name);

    Product findByDescription(String description);
}
