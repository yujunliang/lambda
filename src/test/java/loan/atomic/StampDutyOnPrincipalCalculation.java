package loan.atomic;

import com.google.common.base.Function;
import loan.domain.FinancialInstrument;
import loan.domain.Rate;

public class StampDutyOnPrincipalCalculation<T extends FinancialInstrument> implements Function<T, T>{
    private final Rate rate;

    public StampDutyOnPrincipalCalculation(Rate rate) {
        this.rate = rate;
    }

    @Override
    public T apply(T financialInstrument) {
        financialInstrument.setStampDuty(
                financialInstrument.getPrincipal().multiply(rate)
        );
        return financialInstrument;
    }
}
