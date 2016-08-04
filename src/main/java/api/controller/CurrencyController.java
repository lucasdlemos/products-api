package api.controller;

import api.domain.Currency;
import api.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lucaslemos on 8/3/16.
 */
@RestController
@RequestMapping("/currency")
public class CurrencyController extends AbstractCrudController<Currency, CurrencyService> {

    @Autowired
    protected CurrencyController(CurrencyService service) {
        super(service);
    }
}
