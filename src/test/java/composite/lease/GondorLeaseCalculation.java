package composite.lease;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static composite.FinancialInstrument.RATE_2;

public final class GondorLeaseCalculation extends CompositeFunction<Lease, Lease> {

    public GondorLeaseCalculation() {
        super(
            new SetMonthlyPayment<>(new MonthlyLeasePayment<>()),
            new SetStampDuty<>(new StampDutyOnMonthlyPayment<>(RATE_2)),
            new SetFirstMonthPayment<>(new SumMonthlyPaymentAndStampDuty<>())
        );
    }
}
