package functions.atomic;

import com.google.common.base.Function;
import functions.primitives.Amount;
import functions.primitives.Principal;

public class SetPrincipal<T extends Principal> implements Function<T, T> {

    private final Function<Principal, Amount> add;

    public SetPrincipal(Function<Principal, Amount> add) {
        this.add = add;
    }

    @Override
    public T apply(T t) {
        t.setPrincipal(add.apply(t));
        return t;
    }
}
