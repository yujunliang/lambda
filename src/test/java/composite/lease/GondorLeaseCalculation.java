package composite.lease;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static functions.primitives.Rate.valueOf;

public final class GondorLeaseCalculation extends CompositeFunction<Lease, Lease> {

    public GondorLeaseCalculation() {
        super(
              new SetMonthlyPayment(new MonthlyLeasePayment()),
              new SetStampDuty(new StampDutyOnMonthlyPayment(valueOf(0.02))),
              new SetFirstMonthPayment(new SumMonthlyPaymentAndStampDuty())
        );
    }
}
