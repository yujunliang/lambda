package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.Principal;

public class AddApplicationFeeToPrincipal<T1 extends Principal> implements Function<T1, Amount> {
    @Override
    public Amount apply(T1 financialInstrument) {
        return financialInstrument.getPrincipal().plus(financialInstrument.getApplicationFee());
    }
}
