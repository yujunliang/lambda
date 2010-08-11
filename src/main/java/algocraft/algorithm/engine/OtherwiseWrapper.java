package algocraft.algorithm.engine;

import algocraft.algorithm.AlgorithmException;
import algocraft.algorithm.Otherwise;
import algocraft.algorithm.Applicability;
import algocraft.algorithm.Solution;

final class OtherwiseWrapper<T> implements Solution<T> {

	private final Solution<T> algorithm;
	private final Applicability<T> applicability;
	private final Otherwise<T> alternative;

	public OtherwiseWrapper(final Solution<T> alglrithm,
			final Applicability<T> algorithm2, final Otherwise<T> alternative) {
		this.algorithm = alglrithm;
		this.applicability = algorithm2;
		this.alternative = alternative;

	}

	@Override
	public void solve(final T problem) throws AlgorithmException {
		if (applicability.isApplicable(problem)) {
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