package api.controller;

import api.domain.Product;
import api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lucaslemos on 8/3/16.
 */

@RestController
@RequestMapping("/product")
public class ProductController extends AbstractCrudController<Product, ProductService> {

    @Autowired
    protected ProductController(ProductService service) {
        super(service);
    }

    @RequestMapping("/findByName")
    public Product findByName(@RequestParam String name) {
        return service.findByName(name);
    }

    @RequestMapping("findByDescription")
    public Product findByDescription(@RequestParam String description) {
        return service.findByDescription(description);
    }
}
