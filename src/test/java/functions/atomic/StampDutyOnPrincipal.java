package functions.atomic;

import com.google.common.base.Function;
import functions.primitives.Amount;
import functions.primitives.PrincipalAndApplicationFee;
import functions.primitives.Rate;

public class StampDutyOnPrincipal<T extends PrincipalAndApplicationFee> implements Function<T, Amount>{
    private final Rate rate;

    public StampDutyOnPrincipal(Rate rate) {
        this.rate = rate;
    }

    @Override
    public Amount apply(T t) {
        return t.getPrincipal().times(rate);
    }
}
