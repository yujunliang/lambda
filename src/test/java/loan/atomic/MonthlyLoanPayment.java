package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.MonthlyPaymentCaculatable;

import static loan.atomic.FinancialCalculator.monthlyLoanPayment;
import static loan.primitives.Amount.valueOf;

public class MonthlyLoanPayment implements Function<MonthlyPaymentCaculatable, Amount> {
    @Override
    public Amount apply(MonthlyPaymentCaculatable loan) {
        return valueOf(monthlyLoanPayment(loan.getRate().doubleValue(),
                loan.getTerm() * 12,
                loan.getPrincipal().doubleValue()));
    }
}
