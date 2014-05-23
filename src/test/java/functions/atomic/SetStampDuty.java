package functions.atomic;

import functions.primitives.Amount;
import functions.primitives.StampDuty;

import java.util.function.Function;

public class SetStampDuty<T extends StampDuty> implements Function<T, T> {

    private final Function<T, Amount> function;

    public SetStampDuty(Function<T, Amount> function) {
        this.function = function;
    }

    @Override
    public T apply(T t) {
        t.setStampDuty(function.apply(t));
        return t;
    }
}
