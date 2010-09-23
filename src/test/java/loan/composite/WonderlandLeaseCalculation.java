package loan.composite;


import algocraft.function.CompositeFunction;
import loan.atomic.FirstMonthPaymentCalculation;
import loan.atomic.MonthlyLeasePaymentCalculation;
import loan.atomic.SetStampDuty;
import loan.atomic.StampDutyOnPrincipal;
import loan.domain.Lease;

import static loan.primitives.Rate.valueOf;

public final class WonderlandLeaseCalculation extends CompositeFunction<Lease, Lease> {

    public WonderlandLeaseCalculation() {
        super(
              MonthlyLeasePaymentCalculation.INSTANCE,
              new SetStampDuty(new StampDutyOnPrincipal(valueOf(0.03))),
              new FirstMonthPaymentCalculation()
        );
    }
}
