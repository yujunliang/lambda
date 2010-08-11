package domain;

import java.util.Date;

/**
 * @author  yujunliang
 */
public final class SubOutput2 extends Domain {

	private Date date;

	public void setDate(final Date date1) {
		this.date = new Date(date1.getTime());
		
	}

	public Date getDate() {
		return new Date(date.getTime());
	}

}
