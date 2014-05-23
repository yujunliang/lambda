package functions.atomic;

import functions.primitives.Amount;
import functions.primitives.PrincipalAndApplicationFee;

import java.util.function.Function;

public class AddApplicationFeeToPrincipal<T extends PrincipalAndApplicationFee> implements Function<T, Amount> {
    @Override
    public Amount apply(T t) {
        return t.getPrincipal().plus(t.getApplicationFee());
    }
}
