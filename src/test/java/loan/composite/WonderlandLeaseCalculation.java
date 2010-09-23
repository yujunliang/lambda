package loan.composite;


import algocraft.function.CompositeFunction;
import loan.atomic.FirstMonthPaymentCalculation;
import loan.atomic.MonthlyLeasePaymentCalculation;
import loan.atomic.MonthlyLoanPaymentCalculation;
import loan.atomic.StampDutyOnPrincipalCalculation;
import loan.domain.Lease;
import loan.domain.Loan;

import static loan.domain.Rate.valueOf;

public final class WonderlandLeaseCalculation extends CompositeFunction<Lease, Lease> {

    public WonderlandLeaseCalculation() {
        super(
              MonthlyLeasePaymentCalculation.INSTANCE,
              new StampDutyOnPrincipalCalculation(valueOf(0.03)),
              new FirstMonthPaymentCalculation()
        );
    }
}
