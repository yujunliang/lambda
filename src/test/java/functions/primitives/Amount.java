package functions.primitives;

import java.math.BigDecimal;


/**
 * A class to represent amount, refer to Money in Patterns of Enterprise
 * Architecture by Martin Fowler.
 *
 * @author yujunliang
 */
public class Amount {

    private static final int CENTS = 2;
    public static final Amount ZERO = Amount.valueOf(0);

    public static Amount valueOf(double d) {
        return new Amount(d);
    }

    private BigDecimal amount;

    public Amount(String d) {
        amount = BigDecimal.valueOf(Double.parseDouble(d))
                .setScale(CENTS, BigDecimal.ROUND_HALF_UP);
    }

    public Amount(double d) {
        amount = BigDecimal.valueOf(d)
                .setScale(CENTS, BigDecimal.ROUND_HALF_UP);
    }

    public long centValue() {
        return (long) (doubleValue() * 100);
    }

    public Amount devide(int int1) {
        return valueOf(doubleValue() / int1);
    }

    @Override
    public boolean equals(Object that) {
        return (this == that)
                || (that instanceof Amount && (((Amount) that).amount
                .equals(this.amount)));
    }

    @Override
    public int hashCode() {
        return amount.hashCode();
    }

    public Amount times(int quantity) {
        return valueOf(this.doubleValue() * quantity);
    }

    public Amount times(Rate rate) {
        double r = rate == null ? 0.0 : rate.doubleValue();
        return valueOf(this.doubleValue() * r);
    }

    public Amount plus(Amount amount) {
        return valueOf(doubleValue() + nullSafeAmount(amount));
    }

    private double nullSafeAmount(Amount amount) {
        return amount == null ? 0 : amount.doubleValue();
    }

    public Amount plus(double i) {
        return valueOf(this.amount.doubleValue() + i);
    }

    @Override
    public String toString() {
        return amount.toString();
    }

    public double doubleValue() {
        return amount.doubleValue();
    }

    public BigDecimal value() {
        return amount;
    }

    public Amount minus(Amount amount) {
        return valueOf(doubleValue() - nullSafeAmount(amount));
    }
}
