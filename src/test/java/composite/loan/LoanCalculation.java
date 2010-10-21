package composite.loan;

import algocraft.function.CaseFunction;
import composite.Country;
import functions.atomic.GetCountry;

import static composite.Country.*;

public class LoanCalculation extends CaseFunction<Loan, Loan, Country> {

    public LoanCalculation() {
        super(new GetCountry(),
                GD, new GondorLoanCalculation(),
                NR, new NarniaLoanCalculation(),
                WL, new WonderlandLoanCalculation());
    }
}
