package loan.composite;


import algocraft.function.CompositeFunction;
import loan.atomic.*;
import loan.domain.Loan;

import static loan.primitives.Rate.valueOf;

public final class WonderlandLoanCalculation extends CompositeFunction<Loan, Loan> {

    public WonderlandLoanCalculation() {
        super(
              new SetMonthlyPayment(new MonthlyLoanPayment()),
              new SetStampDuty(new StampDutyOnPrincipal(valueOf(0.03))),
              new FirstMonthPaymentCalculation()
        );
    }
}
