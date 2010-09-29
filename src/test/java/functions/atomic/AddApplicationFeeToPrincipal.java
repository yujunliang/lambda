package functions.atomic;

import com.google.common.base.Function;
import functions.primitives.Amount;
import functions.primitives.PrincipalAndApplicationFee;

public class AddApplicationFeeToPrincipal<T extends PrincipalAndApplicationFee> implements Function<T, Amount> {
    @Override
    public Amount apply(T t) {
        return t.getPrincipal().plus(t.getApplicationFee());
    }
}
