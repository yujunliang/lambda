package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Country;
import loan.domain.Loan;

public enum GetCountryFromLoan implements Function<Loan, Country> {
    INSTANCE;
    @Override
    public Country apply(Loan loan) {
        return loan.getCountry();
    }
}