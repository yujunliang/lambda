package composite.loan;

import algocraft.function.CaseFunction;
import functions.atomic.GetCountry;
import composite.Country;

import static composite.Country.*;

public class LoanCalculation extends CaseFunction<Loan, Loan, Country> {

    public LoanCalculation() {
        super(new GetCountry(),
                GD, new GondorLoanCalculation(),
                NR, new NarniaLoanCalculation(),
                WL, new WonderlandLoanCalculation());
    }
}
