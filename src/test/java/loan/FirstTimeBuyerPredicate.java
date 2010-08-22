package loan;

import com.google.common.base.Predicate;

import static algocraft.util.Logic.not;

public final class FirstTimeBuyerPredicate implements Predicate<Worksheet> {

	@Override
	public boolean apply(final Worksheet worksheet) {
		return not(worksheet.isFTBuyer());
	}
}