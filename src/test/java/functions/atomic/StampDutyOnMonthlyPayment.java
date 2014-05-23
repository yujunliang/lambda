package functions.atomic;

import functions.primitives.Amount;
import functions.primitives.FirstMonthPaymentWithStampDuty;
import functions.primitives.Rate;

import java.util.function.Function;

public class StampDutyOnMonthlyPayment<T extends FirstMonthPaymentWithStampDuty> implements Function<T, Amount> {

    private final Rate rate;

    public StampDutyOnMonthlyPayment(Rate rate) {
        this.rate = rate;
    }

    @Override
    public Amount apply(T t) {
        return t.getMonthPayment().times(rate);
    }
}
