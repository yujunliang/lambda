package loan.composite;

import algocraft.function.CaseFunction;
import loan.atomic.GetCountry;
import loan.domain.Country;
import loan.domain.Loan;

import static loan.domain.Country.*;

public class LoanCalculation extends CaseFunction<Loan, Loan, Country> {

    public LoanCalculation() {
        super(new GetCountry(),
                GD, new GondorLoanCalculation(),
                NR, new NarniaLoanCalculation(),
                WL, new WonderlandLoanCalculation());
    }
}
