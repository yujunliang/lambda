package loan.composite;

import com.google.common.base.Function;
import loan.domain.Country;
import loan.domain.Loan;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static loan.domain.Country.GD;
import static loan.domain.Country.NR;
import static loan.domain.Country.WL;

public class LoanCalculation implements Function<Loan, Loan> {
    private static final Map<Country, Function<Loan, Loan>> calculationByCountry = init();

    private static Map<Country, Function<Loan, Loan>> init() {
        Map<Country, Function<Loan, Loan>> functions = newHashMap();
        functions.put(GD, new GondorCalculation());
        functions.put(NR, new NarniaCalculation());
        functions.put(WL, new WonderlandCalculation());
        return functions;
    }

    @Override
    public Loan apply(Loan loan) {
        return calculationByCountry.get(loan.getCountry()).apply(loan);
    }
}
