package loan.atomic;

import com.google.common.base.Function;
import loan.primitives.Amount;
import loan.primitives.MonthlyPaymentCaculatable;

public class SetMonthlyPayment<T extends MonthlyPaymentCaculatable> implements Function<T, T>{

    private final Function<T, Amount> calc;

    public SetMonthlyPayment(Function<T, Amount> calc) {
        this.calc = calc;
    }

    @Override
    public T apply(T t) {
        t.setMonthPayment(calc.apply(t));
        return t;
    }    
}
