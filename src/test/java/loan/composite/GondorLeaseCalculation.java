package loan.composite;


import algocraft.function.CompositeFunction;
import loan.atomic.FirstMonthPaymentCalculation;
import loan.atomic.MonthlyLeasePaymentCalculation;
import loan.atomic.SetStampDuty;
import loan.atomic.StampDutyOnMonthlyPayment;
import loan.domain.Lease;

import static loan.primitives.Rate.valueOf;

public final class GondorLeaseCalculation extends CompositeFunction<Lease, Lease> {

    public GondorLeaseCalculation() {
        super(
              MonthlyLeasePaymentCalculation.INSTANCE,
              new SetStampDuty(new StampDutyOnMonthlyPayment(valueOf(0.02))),
              new FirstMonthPaymentCalculation()
        );
    }
}
