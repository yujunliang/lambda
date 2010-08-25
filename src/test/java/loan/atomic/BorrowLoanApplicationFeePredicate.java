package loan.atomic;

import com.google.common.base.Predicate;
import loan.domain.Loan;

public enum BorrowLoanApplicationFeePredicate implements Predicate<Loan> {
    INSTANCE;
	@Override
	public boolean apply(final Loan loan) {
		return loan.isBorrowLoanApplicationFee();
	}
}