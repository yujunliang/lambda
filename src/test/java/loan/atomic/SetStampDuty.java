package loan.atomic;

import com.google.common.base.Function;
import loan.domain.FinancialInstrument;
import loan.primitives.Amount;
import loan.primitives.StampDuty;

public class SetStampDuty<T extends StampDuty> implements Function<T, T> {

    private final Function<StampDuty, Amount> function;

    public SetStampDuty(Function<StampDuty, Amount> function) {
        this.function = function;
    }

    @Override
    public T apply(T t) {
        t.setStampDuty(function.apply(t));
        return t;
    }
}
