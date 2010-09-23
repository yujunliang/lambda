package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.FirstMonthPaymentWithStampDuty;

public class SumMonthlyPaymentAndStampDuty<T extends FirstMonthPaymentWithStampDuty> implements Function<T, Amount> {
    @Override
    public Amount apply( T financialInstrument) {
        return financialInstrument.getMonthPayment().plus(financialInstrument.getStampDuty());
    }
}
