package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.Principal;

public class SetPrincipal<T1 extends Principal> implements Function<T1, T1> {

    Function<Principal, Amount> add = new AddApplicationFeeToPrincipal();
    
    @Override
    public T1 apply(T1 financialInstrument) {
        financialInstrument.setPrincipal(add.apply(financialInstrument));
        return financialInstrument;
    }
}
