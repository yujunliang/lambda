package domain;

import java.math.BigDecimal;

public final class Amount {

	private static final int CENTS = 2;
	public static Amount valueOf(final double value) {
		return new Amount(value);
	}

	private final BigDecimal value;

	private Amount(final double value) {
		this.value = BigDecimal.valueOf(value).setScale(CENTS);
	}

	public Amount devide(final int value) {
		return valueOf(this.value.doubleValue() / value);
	}

	@Override
	public boolean equals(final Object that) {
		return (this == that) //
				|| ((that != null) //
						&& (that instanceof Amount)//
				&& this.value.equals(((Amount) that).value)//
				);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public Amount plus(final double value) {
		return valueOf(this.value.doubleValue() + value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
