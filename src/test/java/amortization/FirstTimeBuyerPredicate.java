package amortization;

import algocraft.util.Logic;
import algorithm.atomic.Problem;
import com.google.common.base.Predicate;

import static algocraft.util.Logic.not;

public final class FirstTimeBuyerPredicate implements Predicate<Worksheet> {

	@Override
	public boolean apply(final Worksheet worksheet) {
		return not(worksheet.isFTBuyer());
	}
}