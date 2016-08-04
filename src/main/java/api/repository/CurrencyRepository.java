package api.repository;

import api.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lucaslemos on 8/3/16.
 */
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

    Currency findBySymbol(String symbol);
}
