package loan.composite;

import com.google.common.base.Function;
import loan.domain.Country;
import loan.domain.Loan;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class LoanCalculation implements Function<Loan, Loan> {
    private static final Map<Country, Function<Loan, Loan>> calculationByCountry = init();

    private static Map<Country, Function<Loan, Loan>> init() {
        Map<Country, Function<Loan, Loan>> functions = newHashMap();
        functions.put(Country.GD, new GondorCalculation());
        functions.put(Country.NR, new NarniaCalculation());
        functions.put(Country.WL, new WonderlandCalculation());
        return functions;
    }

    @Override
    public Loan apply(Loan loan) {
        return calculationByCountry.get(loan.getCountry()).apply(loan);
    }
}
