package composite.lease;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static functions.primitives.Rate.valueOf;

public final class NarniaLeaseCalculation extends CompositeFunction<Lease, Lease> {

    public NarniaLeaseCalculation() {
        super(
                new SetMonthlyPayment<Lease>(new MonthlyLeasePayment<Lease>()),
                new SetStampDuty<Lease>(new StampDutyOnMonthlyPayment<Lease>(valueOf(0.03))),
                new SetFirstMonthPayment<Lease>(new SumMonthlyPaymentAndStampDuty<Lease>()),
                new SetFirstMonthPayment<Lease>(new AddApplicationFeeToFirstMonthPayment<Lease>())
        );
    }
}
