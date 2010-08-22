package loan.atomic;

import com.google.common.base.Predicate;
import loan.domain.Worksheet;

import static algocraft.util.Logic.not;

public final class PayLoanApplicationFeePredicate implements Predicate<Worksheet> {

	@Override
	public boolean apply(final Worksheet worksheet) {
		return not(worksheet.isBorrowLoanApplicationFee());
	}
}