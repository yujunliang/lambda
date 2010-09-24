package loan.atomic;

import com.google.common.base.Predicate;
import loan.domain.FinancialInstrument;
import loan.primitives.FirstTimeBuyer;

public class FirstTimeBuyerPredicate<T extends FirstTimeBuyer> implements Predicate<T> {

	@Override
	public boolean apply(final T t) {
		return t.isFirstTimeBuyer();
	}
}