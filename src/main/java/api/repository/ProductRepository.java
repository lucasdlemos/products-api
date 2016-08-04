package api.repository;

import api.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lucaslemos on 8/3/16.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);

    Product findByDescription(String description);
}
