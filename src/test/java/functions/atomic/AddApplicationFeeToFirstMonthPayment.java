package functions.atomic;

import functions.primitives.Amount;
import functions.primitives.FirstMonthPaymentWithApplicationFee;

import java.util.function.Function;

public class AddApplicationFeeToFirstMonthPayment<T extends FirstMonthPaymentWithApplicationFee> implements Function<T, Amount> {
    @Override
    public Amount apply(T t) {
        return t.getFirstMonthPayment().plus(t.getApplicationFee());
    }
}
