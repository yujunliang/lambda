/**
 * Copyright 2005 ThoughtWorks, Inc. All rights reserved.
 * Use is subject to license terms.
 */
package functions.primitives;

import java.math.BigDecimal;

public class Rate {

	private static final int SCALE_OF_TWO = 2;

	public static final Rate ZERO = new Rate(0);

	public static Rate valueOf(double d) {
		return new Rate(d);
	}

	private BigDecimal rate;

	private Rate(double d) {
		if (d > 100)
			throw new RuntimeException("rate can't be over 100.");
		rate = BigDecimal.valueOf(d).setScale(SCALE_OF_TWO);
	}

	public double doubleValue() {
		return rate.doubleValue();
	}

	@Override
	public boolean equals(Object that) {
		return (this == that)
				|| ((that instanceof Rate) && this.rate
						.equals(((Rate) that).rate));
	}

	@Override
	public int hashCode() {
		return rate.hashCode();
	}

	public Rate plus(Rate rate) {
		return Rate.valueOf(this.rate.add(rate.rate).doubleValue());
	}

	@Override
	public String toString() {
		return String.valueOf(rate);
	}

}
