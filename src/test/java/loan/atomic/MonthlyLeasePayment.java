package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.Leasable;

import static loan.atomic.FinancialCalculator.monthlyLeasePayment;
import static loan.primitives.Amount.valueOf;

public class MonthlyLeasePayment<T extends Leasable> implements Function<T, Amount>{

    @Override
    public Amount apply(T t) {
        return valueOf(
           monthlyLeasePayment(t.getRate().doubleValue(),
                               t.getTerm()*12,
                               t.getPrincipal().doubleValue(),t.getResidualValue().doubleValue()));
    }    
}
