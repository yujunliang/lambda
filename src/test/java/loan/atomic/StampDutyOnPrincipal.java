package loan.atomic;

import com.google.common.base.Function;
import loan.domain.FinancialInstrument;
import loan.primitives.Amount;
import loan.primitives.Principal;
import loan.primitives.Rate;

public class StampDutyOnPrincipal<T extends FinancialInstrument> implements Function<T, Amount>{
    private final Rate rate;

    public StampDutyOnPrincipal(Rate rate) {
        this.rate = rate;
    }

    @Override
    public Amount apply(T financialInstrument) {
        return financialInstrument.getPrincipal().multiply(rate);
    }
}
