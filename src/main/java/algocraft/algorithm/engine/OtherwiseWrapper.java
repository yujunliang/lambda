package algocraft.algorithm.engine;

import algocraft.algorithm.AlgorithmException;
import algocraft.algorithm.Otherwise;
import algocraft.algorithm.Solution;
import com.google.common.base.Predicate;

final class OtherwiseWrapper<T> implements Solution<T> {

	private final Solution<T> algorithm;
	private final Predicate<T> predicate;
	private final Otherwise<T> alternative;

	public OtherwiseWrapper(final Solution<T> alglrithm,
			final Predicate<T> algorithm2, final Otherwise<T> alternative) {
		this.algorithm = alglrithm;
		this.predicate = algorithm2;
		this.alternative = alternative;

	}

	@Override
	public void solve(final T problem) throws AlgorithmException {
		if (predicate.apply(problem)) {
			algorithm.solve(problem);
		} else {
			alternative.otherwise(problem);
		}
	}

	@Override
	public String toString() {
		return algorithm.toString();
	}
}
