package functions.atomic;

import com.google.common.base.Predicate;
import functions.primitives.FinanceApplicationFee;

public class FinanceApplicationFeePredicate<T extends FinanceApplicationFee> implements Predicate<T> {

	@Override
	public boolean apply(final T t) {
		return t.isFinanceApplicationFee();
	}
}