package api.util;

import api.domain.Currency;
import api.domain.PricePoint;
import api.domain.Product;
import api.domain.Tag;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucaslemos on 8/4/16.
 */
public class SampleProductCreator {

    public static final String TAG_NAME = "newTag";
    public static final String CURRENCY_SYMBOL = "USD";

    public static SampleProductCreator instance() {
        return new SampleProductCreator();
    }

    public Product createAValidProduct() {
        Product product = new Product();
        product.setName("name");
        product.setDescription("description");
        product.setTags(createTags());
        product.setPricePoints(createPricePoints());
        return product;
    }

    public List<PricePoint> createPricePoints() {
        List<PricePoint> pricePoints = new ArrayList<>();
        PricePoint pricePoint = new PricePoint();
        pricePoint.setCurrency(createCurrency());
        pricePoint.setProductValue(BigDecimal.TEN);
        pricePoints.add(pricePoint);
        return pricePoints;
    }

    public Currency createCurrency() {
        Currency currency = new Currency();
        currency.setSymbol(CURRENCY_SYMBOL);
        return currency;
    }

    public List<Tag> createTags() {
        List<Tag> tags = new ArrayList<>();
        Tag tag = new Tag();
        tag.setName(TAG_NAME);
        tags.add(tag);
        return tags;
    }


}
