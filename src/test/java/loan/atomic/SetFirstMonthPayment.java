package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.FirstMonthPayment;

public class SetFirstMonthPayment<T1 extends FirstMonthPayment> implements Function<T1, T1> {

    Function<T1, Amount> add = new AddApplicationFeeToFirstMonthPayment();
    
    @Override
    public T1 apply(T1 financialInstrument) {
        financialInstrument.setFirstMonthPayment(add.apply(financialInstrument));
        return financialInstrument;
    }
}
