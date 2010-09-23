package loan.composite;


import algocraft.function.CompositeFunction;
import loan.atomic.FirstMonthPaymentCalculation;
import loan.atomic.MonthlyLoanPaymentCalculation;
import loan.atomic.StampDutyOnPrincipalCalculation;
import loan.domain.Loan;

import static loan.primitives.Rate.valueOf;

public final class WonderlandLoanCalculation extends CompositeFunction<Loan, Loan> {

    public WonderlandLoanCalculation() {
        super(
              MonthlyLoanPaymentCalculation.INSTANCE,
              new StampDutyOnPrincipalCalculation(valueOf(0.03)),
              new FirstMonthPaymentCalculation()
        );
    }
}
