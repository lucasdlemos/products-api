package api.service;

import api.domain.Product;
import api.repository.ProductRepository;
import api.util.SampleProductCreator;
import api.validator.ProductValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by lucaslemos on 8/4/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private TagService tagService;

    @Mock
    private CurrencyService currencyService;

    @Mock
    private ProductValidator productValidator;

    private Product product;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        product = SampleProductCreator.instance().createAValidProduct();
    }

    @Test
    public void itShouldFindTagsAndCurrencyIfTheyDontHaveId() {
        whenTriesToCreateProduct();
        thenItShouldFindTagsAndCurrencies();
    }

    private void whenTriesToCreateProduct() {
        productService.create(product);
    }

    private void thenItShouldFindTagsAndCurrencies() {
        Mockito.verify(tagService, Mockito.times(1)).findByName(SampleProductCreator.TAG_NAME);
        Mockito.verify(currencyService, Mockito.times(1)).findBySymbol(SampleProductCreator.CURRENCY_SYMBOL);
    }


}
