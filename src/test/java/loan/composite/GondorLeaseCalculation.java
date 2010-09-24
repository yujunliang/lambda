package loan.composite;


import algocraft.function.CompositeFunction;
import loan.atomic.*;
import loan.domain.Lease;

import static loan.primitives.Rate.valueOf;

public final class GondorLeaseCalculation extends CompositeFunction<Lease, Lease> {

    public GondorLeaseCalculation() {
        super(
              new SetMonthlyPayment(new MonthlyLeasePayment()),
              new SetStampDuty(new StampDutyOnMonthlyPayment(valueOf(0.02))),
              new SetFirstMonthPayment(new SumMonthlyPaymentAndStampDuty())
        );
    }
}
