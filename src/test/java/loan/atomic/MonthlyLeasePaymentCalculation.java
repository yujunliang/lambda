package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Lease;
import loan.primitives.Amount;

import static loan.atomic.FinancialCalculator.monthlyLeasePayment;

public enum MonthlyLeasePaymentCalculation implements Function<Lease, Lease>{
    INSTANCE;
    @Override
    public Lease apply(Lease lease) {
        lease.setMonthPayment(
               Amount.valueOf(
                       monthlyLeasePayment(lease.getRate().doubleValue(),
                               lease.getTerm()*12,
                               lease.getPrincipal().doubleValue(),lease.getResidualValue().doubleValue()
                       )
               )
        );
        return lease;
    }    
}
