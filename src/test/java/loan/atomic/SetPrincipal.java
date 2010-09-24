package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.Principal;

public class SetPrincipal<T extends Principal> implements Function<T, T> {

    Function<Principal, Amount> add = new AddApplicationFeeToPrincipal();
    
    @Override
    public T apply(T t) {
        t.setPrincipal(add.apply(t));
        return t;
    }
}
