package loan.composite;

import algocraft.function.CaseFunction;
import loan.domain.Country;
import loan.domain.Loan;

import static loan.domain.Country.*;

public class LoanCalculation extends CaseFunction<Loan, Loan, Country> {

    public LoanCalculation() {
        super(GetCountryFromLoan.INSTANCE,
                GD, new GondorCalculation(),
                NR, new NarniaCalculation(),
                WL, new WonderlandCalculation());
    }
}
