package functions.atomic;

import com.google.common.base.Function;
import functions.primitives.Amount;
import functions.primitives.MonthlyPaymentCaculatable;

import static functions.atomic.FinancialCalculator.monthlyLoanPayment;
import static functions.primitives.Amount.valueOf;

public class MonthlyLoanPayment<T extends MonthlyPaymentCaculatable> implements Function<T, Amount> {
    @Override
    public Amount apply(T t) {
        return valueOf(monthlyLoanPayment(t.getRate().doubleValue(),
                t.getTerm() * 12,
                t.getPrincipal().doubleValue()));
    }
}
