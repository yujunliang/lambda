package composite.loan;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static functions.primitives.Rate.valueOf;

public final class WonderlandLoanCalculation extends CompositeFunction<Loan, Loan> {

    public WonderlandLoanCalculation() {
        super(
              new SetMonthlyPayment(new MonthlyLoanPayment()),
              new SetStampDuty(new StampDutyOnPrincipal(valueOf(0.03))),
              new SetFirstMonthPayment(new SumMonthlyPaymentAndStampDuty())
        );
    }
}