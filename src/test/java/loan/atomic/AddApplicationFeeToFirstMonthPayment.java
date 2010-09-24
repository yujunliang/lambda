package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.FirstMonthPayment;

public class AddApplicationFeeToFirstMonthPayment<T extends FirstMonthPayment> implements Function<T, Amount> {
    @Override
    public Amount apply(T t) {
        return t.getFirstMonthPayment().plus(t.getApplicationFee());
    }
}
