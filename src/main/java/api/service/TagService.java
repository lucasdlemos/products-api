package api.service;

import api.domain.Tag;

/**
 * Created by lucaslemos on 8/3/16.
 */
public interface TagService extends AbstractCrudService<Tag> {

    Tag findByName(String name);
}
