package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.FirstMonthPaymentWithStampDuty;

public class FirstMonthPaymentCalculation<T1 extends FirstMonthPaymentWithStampDuty> implements Function<T1, T1> {

    @Override
    public T1 apply(T1 financialInstrument) {

        financialInstrument.setFirstMonthPayment(
                financialInstrument.getMonthPayment().plus(
                        financialInstrument.getStampDuty()
                )

        );
        return financialInstrument;
    }
}
