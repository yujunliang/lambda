package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.Leasable;

import static loan.atomic.FinancialCalculator.monthlyLeasePayment;
import static loan.primitives.Amount.valueOf;

public class MonthlyLeasePayment implements Function<Leasable, Amount>{

    @Override
    public Amount apply(Leasable lease) {
        return valueOf(
           monthlyLeasePayment(lease.getRate().doubleValue(),
                               lease.getTerm()*12,
                               lease.getPrincipal().doubleValue(),lease.getResidualValue().doubleValue()));
    }    
}
