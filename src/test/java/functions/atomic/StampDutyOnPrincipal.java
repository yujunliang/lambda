package functions.atomic;

import com.google.common.base.Function;
import functions.primitives.Amount;
import functions.primitives.Principal;
import functions.primitives.Rate;

public class StampDutyOnPrincipal<T extends Principal> implements Function<T, Amount>{
    private final Rate rate;

    public StampDutyOnPrincipal(Rate rate) {
        this.rate = rate;
    }

    @Override
    public Amount apply(T t) {
        return t.getPrincipal().multiply(rate);
    }
}
