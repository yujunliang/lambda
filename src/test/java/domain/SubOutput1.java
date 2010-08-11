package domain;

import java.util.Date;

/**
 * @author yujunliang
 */
public final class SubOutput1 extends Domain {

	private Date date1;

	private int int1;

	private Amount amount;

	public Date getDate1() {
		return new Date(date1.getTime());
	}

	public void setDate1(final Date date1) {
		this.date1 = new Date(date1.getTime());
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(final int int1) {
		this.int1 = int1;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(final Amount amount) {
		this.amount = amount;
	}
}
