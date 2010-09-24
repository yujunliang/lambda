package composite.loan;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static functions.primitives.Rate.valueOf;

public final class GondorLoanCalculation extends CompositeFunction<Loan, Loan> {

    public GondorLoanCalculation() {
        super(
              new SetMonthlyPayment(new MonthlyLoanPayment()),
              new SetStampDuty(new StampDutyOnMonthlyPayment(valueOf(0.02))),
              new SetFirstMonthPayment(new SumMonthlyPaymentAndStampDuty())
        );
    }
}
