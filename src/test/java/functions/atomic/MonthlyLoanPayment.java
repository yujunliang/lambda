package functions.atomic;

import functions.primitives.Amount;
import functions.primitives.MonthlyPaymentCaculatable;

import java.util.function.Function;

import static functions.atomic.FinancialCalculator.monthlyLoanPayment;
import static functions.primitives.Amount.valueOf;

public class MonthlyLoanPayment<T extends MonthlyPaymentCaculatable> implements Function<T, Amount> {
    @Override
    public Amount apply(T t) {
        return valueOf(monthlyLoanPayment(t.getRate().value(),
                t.getTerm() * 12,
                t.getPrincipal().value()));
    }
}
