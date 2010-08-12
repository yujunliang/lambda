package algocraft.algorithm.engine;

import algocraft.algorithm.AlgorithmException;
import algocraft.algorithm.Solution;
import com.google.common.base.Predicate;

final class ApplicabilityWrapper<T> implements Solution<T> {

	private final Solution<T> algorithm;
	private final Predicate<T> predicate;

	public ApplicabilityWrapper(final Solution<T> alglrithm,
			final Predicate<T> algorithm2) {
		this.algorithm = alglrithm;
		this.predicate = algorithm2;

	}

	@Override
	public void solve(final T problem) throws AlgorithmException  {
		if (predicate.apply(problem)) {
			algorithm.solve(problem);
		} 
	}

	@Override
	public String toString() {
		return algorithm.toString();
	}
}
