package functions.atomic;

import com.google.common.base.Function;
import functions.primitives.Amount;
import functions.primitives.FirstMonthPaymentWithStampDuty;

public class SetFirstMonthPayment<T extends FirstMonthPaymentWithStampDuty> implements Function<T, T> {

    private final Function<T, Amount> add;

    public SetFirstMonthPayment(Function<T, Amount> add) {
        this.add = add;
    }

    @Override
    public T apply(T t) {
        t.setFirstMonthPayment(add.apply(t));
        return t;
    }
}
