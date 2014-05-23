package composite.lease;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static composite.FinancialInstrument.RATE_3;

public final class NarniaLeaseCalculation extends CompositeFunction<Lease, Lease> {

    public NarniaLeaseCalculation() {
        super(
                new SetMonthlyPayment<>(new MonthlyLeasePayment<>()),
                new SetStampDuty<>(new StampDutyOnMonthlyPayment<>(RATE_3)),
                new SetFirstMonthPayment<>(new SumMonthlyPaymentAndStampDuty<>()),
                new SetFirstMonthPayment<>(new AddApplicationFeeToFirstMonthPayment<>())
        );
    }
}
