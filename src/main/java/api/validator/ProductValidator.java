package api.validator;

import api.domain.Currency;
import api.domain.PricePoint;
import api.domain.Product;
import api.domain.Tag;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucaslemos on 8/3/16.
 */
@Component
public class ProductValidator {

    public void validateCreate(Product product) {
        validateNotNullData(product);
        validateTags(product);
        validatePricePoints(product);
    }

    private void validateNotNullData(Product product) {
        if(product.getName() == null ||
                product.getDescription() == null ||
                product.getPricePoints() == null ||
                product.getPricePoints().isEmpty()) {
            throw new IllegalArgumentException("product.missingAttribute");
        }
    }

    private void validateTags(Product product) {
        List<Tag> tags = product.getTags();
        if(tags != null && !tags.isEmpty()) {
            for (Tag tag : tags) {
                if(tag.getId() == null && tag.getName() == null) {
                    throw new IllegalArgumentException("product.tags.missingAttribute");
                }
            }
        }
    }

    private void validatePricePoints(Product product) {
        List<PricePoint> pricePoints = product.getPricePoints();
        List<Currency> currentCurrencies = new ArrayList<>();
        for (PricePoint pricePoint : pricePoints) {
            if(pricePoint.getCurrency() == null ||
                    pricePoint.getProductValue() == null) {
                throw new IllegalArgumentException("product.pricePoints.missingAttribute");
            }
            validateCurrency(pricePoint.getCurrency(), currentCurrencies);
        }
    }

    private void validateCurrency(Currency currency, List<Currency> currentCurrencies) {
        if(currency.getId() == null &&
                currency.getSymbol() == null) {
            throw new IllegalArgumentException("product.pricePoints.currency.missingAttribute");
        }
        if(currentCurrencies.contains(currency)) {
            throw  new IllegalArgumentException("product.pricePoints.currency.cannotDuplicateCurrency");
        }
        currentCurrencies.add(currency);
    }


}
