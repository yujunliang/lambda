package loan.atomic;

import com.google.common.base.Function;
import loan.domain.FinancialInstrument;

public class AddApplicationFeeToFirstMonthPaymentCalculation<T1 extends FinancialInstrument> implements Function<T1, T1> {
    
    @Override
    public T1 apply(T1 financialInstrument) {
        financialInstrument.setFirstMonthPayment(financialInstrument.getFirstMonthPayment().plus(financialInstrument.getApplicationFee()));
        return financialInstrument;
    }
}
