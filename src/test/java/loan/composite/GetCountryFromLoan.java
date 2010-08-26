package loan.composite;

import com.google.common.base.Function;
import loan.domain.Country;
import loan.domain.Loan;

public class GetCountryFromLoan implements Function<Loan, Country> {

    @Override
    public Country apply(Loan loan) {
        return loan.getCountry();
    }
}