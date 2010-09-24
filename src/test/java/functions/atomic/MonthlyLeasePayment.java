package functions.atomic;

import com.google.common.base.Function;
import functions.primitives.Amount;
import functions.primitives.Leasable;

import static functions.atomic.FinancialCalculator.monthlyLeasePayment;
import static functions.primitives.Amount.valueOf;

public class MonthlyLeasePayment<T extends Leasable> implements Function<T, Amount>{

    @Override
    public Amount apply(T t) {
        return valueOf(
           monthlyLeasePayment(t.getRate().doubleValue(),
                               t.getTerm()*12,
                               t.getPrincipal().doubleValue(),t.getResidualValue().doubleValue()));
    }    
}
