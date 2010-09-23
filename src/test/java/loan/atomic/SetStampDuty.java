package loan.atomic;

import com.google.common.base.Function;
import loan.domain.FinancialInstrument;
import loan.primitives.Amount;

public class SetStampDuty<T extends FinancialInstrument> implements Function<T, T> {

    private final Function<FinancialInstrument, Amount> function;

    public SetStampDuty(Function<FinancialInstrument, Amount> function) {
        this.function = function;
    }

    @Override
    public T apply(T financialInstrument) {
        financialInstrument.setStampDuty(function.apply(financialInstrument));
        return financialInstrument;
    }
}
