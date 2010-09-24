package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.FirstMonthPaymentWithStampDuty;
import loan.primitives.Rate;

public class StampDutyOnMonthlyPayment<T extends FirstMonthPaymentWithStampDuty> implements Function<T, Amount> {

    private final Rate rate;

    public StampDutyOnMonthlyPayment(Rate rate) {
        this.rate = rate;
    }

    @Override
    public Amount apply(T t) {
        return t.getMonthPayment().multiply(rate);
    }
}
