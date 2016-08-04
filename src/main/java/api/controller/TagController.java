package api.controller;

import api.domain.Tag;
import api.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lucaslemos on 8/2/16.
 */

@RestController
@RequestMapping("/tag")
public class TagController extends AbstractCrudController<Tag, TagService> {

    @Autowired
    protected TagController(TagService service) {
        super(service);
    }

}
