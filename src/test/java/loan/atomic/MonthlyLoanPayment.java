package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.MonthlyPaymentCaculatable;

import static loan.atomic.FinancialCalculator.monthlyLoanPayment;
import static loan.primitives.Amount.valueOf;

public class MonthlyLoanPayment<T extends MonthlyPaymentCaculatable> implements Function<T, Amount> {
    @Override
    public Amount apply(T t) {
        return valueOf(monthlyLoanPayment(t.getRate().doubleValue(),
                t.getTerm() * 12,
                t.getPrincipal().doubleValue()));
    }
}
