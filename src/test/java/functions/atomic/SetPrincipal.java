package functions.atomic;

import com.google.common.base.Function;
import functions.primitives.Amount;
import functions.primitives.PrincipalAndApplicationFee;

public class SetPrincipal<T extends PrincipalAndApplicationFee> implements Function<T, T> {

    private final Function<T, Amount> add;

    public SetPrincipal(Function<T, Amount> add) {
        this.add = add;
    }

    @Override
    public T apply(T t) {
        t.setPrincipal(add.apply(t));
        return t;
    }
}
