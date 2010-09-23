package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Country;
import loan.domain.FinancialInstrument;

public class GetCountry<T extends FinancialInstrument> implements Function<T, Country> {

    @Override
    public Country apply(T financialInstrument) {
        return financialInstrument.getCountry();
    }
}