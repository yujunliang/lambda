package loan.composite;


import algocraft.function.CompositeFunction;
import loan.atomic.FirstMonthPaymentCalculation;
import loan.atomic.MonthlyLoanPaymentCalculation;
import loan.atomic.StampDutyOnMonthlyPaymentCalculation;
import loan.domain.Loan;

import static loan.primitives.Rate.valueOf;

public final class GondorLoanCalculation extends CompositeFunction<Loan, Loan> {

    public GondorLoanCalculation() {
        super(
              MonthlyLoanPaymentCalculation.INSTANCE,
              new StampDutyOnMonthlyPaymentCalculation(valueOf(0.02)),
              new FirstMonthPaymentCalculation()
        );
    }
}
