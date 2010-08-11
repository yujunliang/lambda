package domain;

import java.util.Date;

/**
 * @author yujunliang
 */
public final class Input extends Domain {

	private boolean condition1;

	private boolean condition2;

	private Amount amount1;

	private int int1;

	private Date date1;

	public boolean isCondition1() {
		return condition1;
	}

	public void setCondition1(final boolean condition1) {
		this.condition1 = condition1;
	}

	public boolean isCondition2() {
		return condition2;
	}

	public void setCondition2(final boolean condition2) {
		this.condition2 = condition2;
	}

	public Amount getAmount1() {
		return amount1;
	}

	public void setAmount(final Amount amount1) {
		this.amount1 = amount1;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(final int int1) {
		this.int1 = int1;
	}

	public Date getDate1() {
		return new Date(date1.getTime());
	}

	public void setDate1(final Date date1) {
		this.date1 = new Date(date1.getTime());
	}

}
