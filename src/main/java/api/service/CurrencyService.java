package api.service;

import api.domain.Currency;

/**
 * Created by lucaslemos on 8/3/16.
 */
public interface CurrencyService extends AbstractCrudService<Currency> {

    Currency findBySymbol(String symbol);
}
