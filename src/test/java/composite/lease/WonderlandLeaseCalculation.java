package composite.lease;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static functions.primitives.Rate.valueOf;

public final class WonderlandLeaseCalculation extends CompositeFunction<Lease, Lease> {

    public WonderlandLeaseCalculation() {
        super(
                new SetMonthlyPayment<Lease>(new MonthlyLeasePayment<Lease>()),
                new SetStampDuty<Lease>(new StampDutyOnPrincipal<Lease>(valueOf(0.03))),
                new SetFirstMonthPayment<Lease>(new SumMonthlyPaymentAndStampDuty<Lease>())
        );
    }
}
