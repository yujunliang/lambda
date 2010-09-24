package loan.atomic;

import com.google.common.base.Predicate;
import loan.primitives.FinanceApplicationFee;

public class BorrowLoanApplicationFeePredicate<T extends FinanceApplicationFee> implements Predicate<T> {

	@Override
	public boolean apply(final T t) {
		return t.isFinanceApplicationFee();
	}
}