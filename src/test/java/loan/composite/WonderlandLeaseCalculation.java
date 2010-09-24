package loan.composite;


import algocraft.function.CompositeFunction;
import loan.atomic.*;
import loan.domain.Lease;

import static loan.primitives.Rate.valueOf;

public final class WonderlandLeaseCalculation extends CompositeFunction<Lease, Lease> {

    public WonderlandLeaseCalculation() {
        super(
              new SetMonthlyPayment(new MonthlyLeasePayment()),
              new SetStampDuty(new StampDutyOnPrincipal(valueOf(0.03))),
              new SetFirstMonthPayment( new SumMonthlyPaymentAndStampDuty())
        );
    }
}
