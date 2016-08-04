package api.validator;

import api.domain.Currency;
import api.domain.PricePoint;
import api.domain.Product;
import api.domain.Tag;
import api.util.SampleProductCreator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lucaslemos on 8/4/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductValidatorTest {

    @InjectMocks
    private ProductValidator productValidator;

    private Product product;

    @Before
    public void before() {
        product = SampleProductCreator.instance().createAValidProduct();
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldNotCreateProductWithoutName() {
        givenAProductWithoutName();
        whenValidatesCreateProduct();
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldNotCreateProductWithoutDescription() {
        givenAProductWithoutDescription();
        whenValidatesCreateProduct();
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldNotCreateProductWithoutPricePoint() {
        givenAProductWithoutPricePoint();
        whenValidatesCreateProduct();
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldNotCreateProductWithTagWithoutNameAndId() {
        givenAProductWithAnEmptyTag();
        whenValidatesCreateProduct();
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldNotCreateProductWithCurrencyWithoutSymbolAndId() {
        givenAProductWithCurrencyWithoutSymbolAndId();
        whenValidatesCreateProduct();
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldNotCreateProductWithDuplicateCurrencies() {
        givenAProductWithDuplicateCurrencies();
        whenValidatesCreateProduct();
    }

    @Test
    public void itShouldCreateAValidProduct() {
        whenValidatesCreateProduct();
    }

    private void givenAProductWithoutName() {
        product.setName(null);
    }

    private void givenAProductWithoutDescription() {
        product.setDescription(null);
    }

    private void givenAProductWithoutPricePoint() {
        product.setPricePoints(null);
    }

    private void givenAProductWithAnEmptyTag() {
        List<Tag> tags = SampleProductCreator.instance().createTags();
        tags.add(new Tag());
        product.setTags(tags);
    }

    private void givenAProductWithCurrencyWithoutSymbolAndId() {
        List<PricePoint> pricePoints = SampleProductCreator.instance().createPricePoints();
        pricePoints.get(0).setCurrency(new Currency());
        product.setPricePoints(pricePoints);
    }

    private void givenAProductWithDuplicateCurrencies() {
        List<PricePoint> pricePoints = SampleProductCreator.instance().createPricePoints();
        PricePoint pricePoint =  new PricePoint();
        pricePoint.setCurrency(SampleProductCreator.instance().createCurrency());
        pricePoint.setProductValue(BigDecimal.ONE);
        pricePoints.add(pricePoint);
        product.setPricePoints(pricePoints);
    }

    private void whenValidatesCreateProduct() {
        productValidator.validateCreate(product);
    }
}
