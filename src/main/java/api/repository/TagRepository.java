package api.repository;

import api.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lucaslemos on 8/2/16.
 */
public interface TagRepository extends JpaRepository<Tag, Integer> {

    Tag findByName(String name);

}
