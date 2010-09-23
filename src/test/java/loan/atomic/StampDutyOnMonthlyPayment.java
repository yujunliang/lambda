package loan.atomic;

import com.google.common.base.Function;
import loan.domain.FinancialInstrument;
import loan.primitives.Amount;
import loan.primitives.FirstMonthPaymentWithStampDuty;
import loan.primitives.Rate;

public class StampDutyOnMonthlyPayment<T extends FinancialInstrument> implements Function<T, Amount> {

    private final Rate rate;

    public StampDutyOnMonthlyPayment(Rate rate) {
        this.rate = rate;
    }

    @Override
    public Amount apply(T financialInstrument) {
        return financialInstrument.getMonthPayment().multiply(rate);
    }
}
