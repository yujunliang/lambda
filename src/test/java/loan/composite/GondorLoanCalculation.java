package loan.composite;


import algocraft.function.CompositeFunction;
import loan.atomic.*;
import loan.domain.Loan;

import static loan.primitives.Rate.valueOf;

public final class GondorLoanCalculation extends CompositeFunction<Loan, Loan> {

    public GondorLoanCalculation() {
        super(
              new SetMonthlyPayment(new MonthlyLoanPayment()),
              new SetStampDuty(new StampDutyOnMonthlyPayment(valueOf(0.02))),
              new FirstMonthPaymentCalculation()
        );
    }
}
