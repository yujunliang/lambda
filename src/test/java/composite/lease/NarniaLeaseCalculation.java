package composite.lease;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static functions.primitives.Rate.valueOf;

public final class NarniaLeaseCalculation extends CompositeFunction<Lease, Lease> {

	public NarniaLeaseCalculation() {
        super(
              new SetMonthlyPayment(new MonthlyLeasePayment()),
              new SetStampDuty(new StampDutyOnMonthlyPayment(valueOf(0.03))),
              new SetFirstMonthPayment( new SumMonthlyPaymentAndStampDuty()),
              new SetFirstMonthPayment( new AddApplicationFeeToFirstMonthPayment())
        );
	}
}
