package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.FirstMonthPaymentWithStampDuty;

public class SetFirstMonthPayment<T extends FirstMonthPaymentWithStampDuty> implements Function<T, T> {

    private final Function<FirstMonthPaymentWithStampDuty, Amount> add;

    public SetFirstMonthPayment(Function<FirstMonthPaymentWithStampDuty, Amount> add) {
        this.add = add;
    }

    @Override
    public T apply(T t) {
        t.setFirstMonthPayment(add.apply(t));
        return t;
    }
}
