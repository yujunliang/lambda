package loan.atomic;

import com.google.common.base.Predicate;
import loan.domain.Loan;

public final class BorrowLoanApplicationFeePredicate implements Predicate<Loan> {

	@Override
	public boolean apply(final Loan loan) {
		return loan.isBorrowLoanApplicationFee();
	}
}