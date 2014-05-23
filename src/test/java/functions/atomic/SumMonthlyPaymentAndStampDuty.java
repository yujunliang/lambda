package functions.atomic;

import functions.primitives.Amount;
import functions.primitives.FirstMonthPaymentWithStampDuty;

import java.util.function.Function;

public class SumMonthlyPaymentAndStampDuty<T extends FirstMonthPaymentWithStampDuty> implements Function<T, Amount> {
    @Override
    public Amount apply(T t) {
        return t.getMonthPayment().plus(t.getStampDuty());
    }
}
