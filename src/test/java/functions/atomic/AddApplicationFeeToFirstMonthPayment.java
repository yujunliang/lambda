package functions.atomic;

import com.google.common.base.Function;
import functions.primitives.Amount;
import functions.primitives.FirstMonthPayment;

public class AddApplicationFeeToFirstMonthPayment<T extends FirstMonthPayment> implements Function<T, Amount> {
    @Override
    public Amount apply(T t) {
        return t.getFirstMonthPayment().plus(t.getApplicationFee());
    }
}
