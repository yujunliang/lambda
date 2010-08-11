package algocraft.algorithm.engine;

import algocraft.algorithm.AlgorithmException;
import algocraft.algorithm.Solution;

/**
 * Wrapper for Solution
 * 
 * @author yujunliang
 * 
 * @param <E>
 * @param <T>
 */
final class SolutionWrapper<T> implements Solution<T> {

	private final Solution<T> solution;

	SolutionWrapper(final Solution<T> algorithm) {
		this.solution = algorithm;
	}

	@Override
	public void solve(final T problem) throws AlgorithmException  {
		solution.solve(problem);
	}
}