package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.FirstMonthPaymentWithStampDuty;

public class FirstMonthPaymentCalculation<T1 extends FirstMonthPaymentWithStampDuty> implements Function<T1, T1> {

    Function<FirstMonthPaymentWithStampDuty, Amount> add = new SumMonthlyPaymentAndStampDuty();
    @Override
    public T1 apply(T1 t1) {
        t1.setFirstMonthPayment(add.apply(t1));
        return t1;
    }
}
