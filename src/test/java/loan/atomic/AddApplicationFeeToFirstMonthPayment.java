package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.FirstMonthPayment;

public class AddApplicationFeeToFirstMonthPayment<T1 extends FirstMonthPayment> implements Function<T1, Amount> {
    @Override
    public Amount apply( T1 from) {
        return from.getFirstMonthPayment().plus(from.getApplicationFee());
    }
}
