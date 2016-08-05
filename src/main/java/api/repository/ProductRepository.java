package api.repository;

import api.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lucaslemos on 8/3/16.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);

    Product findByDescription(String description);

    /**
     * Returns all the Products that have at least one of these tags
     * @param tagNames
     * @return
     */
    @Query("SELECT p FROM Product p INNER JOIN p.tags t WHERE t.name in :tagNames")
    List<Product> findyByTags(@Param("tagNames") List<String> tagNames);

}
