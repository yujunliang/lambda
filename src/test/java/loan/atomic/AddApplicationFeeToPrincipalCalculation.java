package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Principal;

public class AddApplicationFeeToPrincipalCalculation<T1 extends Principal> implements Function<T1, T1> {
    @Override
    public T1 apply(T1 financialInstrument) {
        financialInstrument.setPrincipal(financialInstrument.getPrincipal().plus(financialInstrument.getApplicationFee()));
        return financialInstrument;
    }
}
