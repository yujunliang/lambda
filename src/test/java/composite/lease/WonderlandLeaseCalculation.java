package composite.lease;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static functions.primitives.Rate.valueOf;

public final class WonderlandLeaseCalculation extends CompositeFunction<Lease, Lease> {

    public WonderlandLeaseCalculation() {
        super(
              new SetMonthlyPayment(new MonthlyLeasePayment()),
              new SetStampDuty(new StampDutyOnPrincipal(valueOf(0.03))),
              new SetFirstMonthPayment( new SumMonthlyPaymentAndStampDuty())
        );
    }
}
