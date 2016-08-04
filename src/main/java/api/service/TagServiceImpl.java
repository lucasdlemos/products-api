package api.service;

import api.domain.Tag;
import api.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucaslemos on 8/2/16.
 */
@Service
@Transactional
public class TagServiceImpl extends AbstractCrudServiceImpl<Tag, TagRepository> implements TagService {

    @Autowired
    protected TagServiceImpl(TagRepository repository) {
        super(repository);
    }

    @Override
    public Tag findByName(String name) {
        return repository.findByName(name);
    }
}
