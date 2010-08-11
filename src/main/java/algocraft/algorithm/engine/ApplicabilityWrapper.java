package algocraft.algorithm.engine;

import algocraft.algorithm.AlgorithmException;
import algocraft.algorithm.Applicability;
import algocraft.algorithm.Solution;

final class ApplicabilityWrapper<T> implements Solution<T> {

	private final Solution<T> algorithm;
	private final Applicability<T> applicability;

	public ApplicabilityWrapper(final Solution<T> alglrithm,
			final Applicability<T> algorithm2) {
		this.algorithm = alglrithm;
		this.applicability = algorithm2;

	}

	@Override
	public void solve(final T problem) throws AlgorithmException  {
		if (applicability.isApplicable(problem)) {
			algorithm.solve(problem);
		} 
	}

	@Override
	public String toString() {
		return algorithm.toString();
	}
}