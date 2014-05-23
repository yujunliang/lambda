package composite.lease;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static composite.FinancialInstrument.RATE_3;

public final class WonderlandLeaseCalculation extends CompositeFunction<Lease, Lease> {

    public WonderlandLeaseCalculation() {
        super(
                new SetMonthlyPayment<>(new MonthlyLeasePayment<>()),
                new SetStampDuty<>(new StampDutyOnPrincipal<>(RATE_3)),
                new SetFirstMonthPayment<>(new SumMonthlyPaymentAndStampDuty<>())
        );
    }
}
