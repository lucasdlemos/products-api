package api.service;

import api.domain.Currency;
import api.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucaslemos on 8/3/16.
 */
@Service
@Transactional
public class CurrencyServiceImpl extends AbstractCrudServiceImpl<Currency, CurrencyRepository> implements CurrencyService {

    @Autowired
    protected CurrencyServiceImpl(CurrencyRepository repository) {
        super(repository);
    }

    @Override
    public Currency findBySymbol(String symbol) {
        return repository.findBySymbol(symbol);
    }
}
