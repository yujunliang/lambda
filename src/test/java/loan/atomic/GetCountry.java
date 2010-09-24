package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Country;
import loan.domain.FinancialInstrument;
import loan.primitives.WithCountry;

public class GetCountry<T extends WithCountry> implements Function<T, Country> {

    @Override
    public Country apply(T financialInstrument) {
        return financialInstrument.getCountry();
    }
}