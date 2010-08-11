package algocraft.algorithm.engine;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import algocraft.algorithm.AlgorithmException;
import algocraft.algorithm.Applicability;
import algocraft.algorithm.Otherwise;
import algocraft.algorithm.Solution;

/**
 * This class is designed for extension, not for instantiation, its derived
 * class can add algorithms in the constructor.
 * 
 * @author yujunliang
 * 
 * @param <T>
 */
public abstract class AbstractAlgorithmCore<T> implements Solution<T> {

	private static final Logger LOG = Logger
			.getLogger(AbstractAlgorithmCore.class);

	private final List<Solution<T>> algorithms = new ArrayList<Solution<T>>();

	private final ProblemSolver solver = ProblemSolver.lookup(this);

	/**
	 * Compose the algorithm. First get a ProblemSolver for the algorithm, then
	 * wrap the ProblemSovler and algorithm into a kind of wrapper based on the
	 * algorithm. If the algorithm is an instance of Applicability, wrap the
	 * wrapper and the algorithm as an instance of Applicability into an
	 * instance of ApplicabilityWrapper. Last, add the wrapper into the list of
	 * Solutions.
	 * 
	 * @param <E>
	 * @param algorithm
	 */
	protected final void add(final Solution<T> algorithm) {

		Solution<T> solution = new SolutionWrapper<T>(algorithm);

		wrap(algorithm, solution);
	}

	protected void wrap(final Solution<T> algorithm, Solution<T> solution) {
		if (algorithm instanceof Applicability<?>) {
			if (algorithm instanceof Otherwise<?>) {
				@SuppressWarnings("unchecked")
				final Applicability<T> applicability = (Applicability<T>) algorithm;
				@SuppressWarnings("unchecked")
				final Otherwise<T> alternative = (Otherwise<T>) algorithm;
				solution = new OtherwiseWrapper<T>(solution, applicability,
						alternative);
			} else {
				@SuppressWarnings("unchecked")
				final Applicability<T> applicability = (Applicability<T>) algorithm;
				solution = new ApplicabilityWrapper<T>(solution, applicability);
			}
		}
		algorithms.add(solution);
	}

	/**
	 * @throws AlgorithmException
	 *             Use the ProblemSovler instance to solve problem by visiting
	 *             the list of Solutions.
	 * @throws
	 */
	@Override
	public final void solve(final T problem) throws AlgorithmException {
		LOG.info(this + " solving " + problem);
		solver.solveAll(algorithms, problem);
	}
}
