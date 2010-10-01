package composite.lease;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static functions.primitives.Rate.valueOf;

public final class GondorLeaseCalculation extends CompositeFunction<Lease, Lease> {

    public GondorLeaseCalculation() {
        super(
                new SetMonthlyPayment<Lease>(new MonthlyLeasePayment<Lease>()),
                new SetStampDuty<Lease>(new StampDutyOnMonthlyPayment<Lease>(valueOf(0.02))),
                new SetFirstMonthPayment<Lease>(new SumMonthlyPaymentAndStampDuty<Lease>())
        );
    }
}
