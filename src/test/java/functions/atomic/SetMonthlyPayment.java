package functions.atomic;

import com.google.common.base.Function;
import functions.primitives.Amount;
import functions.primitives.MonthlyPaymentCaculatable;

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
