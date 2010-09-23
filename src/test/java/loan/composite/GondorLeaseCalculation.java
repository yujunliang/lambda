package loan.composite;


import algocraft.function.CompositeFunction;
import loan.atomic.FirstMonthPaymentCalculation;
import loan.atomic.MonthlyLeasePaymentCalculation;
import loan.atomic.StampDutyOnMonthlyPaymentCalculation;
import loan.domain.Lease;

import static loan.domain.Rate.valueOf;

public final class GondorLeaseCalculation extends CompositeFunction<Lease, Lease> {

    public GondorLeaseCalculation() {
        super(
              MonthlyLeasePaymentCalculation.INSTANCE,
              new StampDutyOnMonthlyPaymentCalculation(valueOf(0.02)),
              new FirstMonthPaymentCalculation()
        );
    }
}
