package api.service;

import api.domain.Currency;
import api.domain.PricePoint;
import api.domain.Product;
import api.domain.Tag;
import api.repository.ProductRepository;
import api.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucaslemos on 8/3/16.
 */
@Service
@Transactional
public class ProductServiceImpl extends AbstractCrudServiceImpl<Product, ProductRepository> implements ProductService {

    @Autowired
    private ProductValidator productValidator;

    @Autowired
    private TagService tagService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    protected ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }

    @Override
    public Product findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Product findByDescription(String description) {
        return repository.findByDescription(description);
    }

    @Override
    public Product create(Product entity) {
        productValidator.validateCreate(entity);
        initTags(entity.getTags());
        initCurrency(entity.getPricePoints());
        return repository.save(entity);
    }

    private void initCurrency(List<PricePoint> pricePoints) {
        for (PricePoint pricePoint : pricePoints) {
            Currency currency = pricePoint.getCurrency();
            if(currency.getId() == null) {
                pricePoint.setCurrency(currencyService.findBySymbol(currency.getSymbol()));
            }
        }
    }

    /**
     * Find tags' references if they do not have id
     * @param tags
     */
    private void initTags(List<Tag> tags) {
        if(tags != null) {
            for (int i = 0; i < tags.size(); i++) {
                Tag tag = tags.get(i);
                if(tag.getId() == null) {
                    tags.set(i, tagService.findByName(tag.getName()));
                }
            }
        }
    }

}
