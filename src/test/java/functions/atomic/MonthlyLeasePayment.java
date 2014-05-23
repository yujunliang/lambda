package functions.atomic;

import functions.primitives.Amount;
import functions.primitives.Leasable;

import java.util.function.Function;

import static functions.atomic.FinancialCalculator.monthlyLeasePayment;
import static functions.primitives.Amount.valueOf;

public class MonthlyLeasePayment<T extends Leasable> implements Function<T, Amount> {

    @Override
    public Amount apply(T t) {
        return
           valueOf(monthlyLeasePayment(t.getRate().value(),
               t.getTerm() * 12,
               t.getPrincipal().value(), t.getResidualValue().value()));
    }    
}
