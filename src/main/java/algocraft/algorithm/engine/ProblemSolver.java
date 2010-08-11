package algocraft.algorithm.engine;

import java.util.List;

import algocraft.algorithm.AlgorithmException;
import algocraft.algorithm.Solution;

/**
 * Singleton ProblemSover to execute algorithms. ProblemSover.PARALLEL will be
 * used for algorithm can be run in parallel; ProblemSover.SEQUENTIAL will be
 * used for algorithms can only be run in sequence. Factory method
 * ProblemSover#of(Algorithm) is used to lookup the right ProblemSolver.
 * Internally, PARALLEL ProblemSolver uses a SWITCH to call either an EXECUTOR
 * which is an ExecutorService or a COMPLETION which is a CompletionService.
 * 
 * This is not a public class so application developer is not required to
 * understand the details of this class. It is only used by AlgorithmCore to run
 * the composite algorithm composed from individual algorithm or other composite
 * algorithms.
 * 
 * This class uses Java 1.6 features such as enumeration, generic class,
 * annotation, concurrent utilities. It applied Singleton and Factory Method
 * patterns from GoF pattern book, used enum as Singleton from Effective Java,
 * Second Edition by Joshua Block and Executor Framework introduced in Java
 * Concurrency in Practice by Brian Goetz.
 * 
 * This class don't use method overloading which is confusing and error prone,
 * all the method can be overloaded as solve, but they are called, solveAll,
 * solveInLoop and solveIteratively.
 * 
 * @author yujunliang
 * 
 */
enum ProblemSolver  {
	


	/**
	 * Sequential Problem Solver
	 */
	SEQUENTIAL {

		@Override
		public final <T> void solveAll(final List<Solution<T>> algorithms, final T problem)
				throws AlgorithmException
				 {
			for (Solution<T> algorithm : algorithms) {
				algorithm.solve(problem);
			}
		}

	};
	
	/**
	 * Return the one of the ProblomSolver depending on the algorithm. If the
	 * algorithm implements Parallelable interface or annotated with Parallel
	 * annotation, return ProblemSolver.PARALLEL, otherwise return
	 * ProblemSolver.SEQUENTIAL.
	 * 
	 * @param algorithm
	 * @return one of the enum constants, PARALLEL or SEQUENTIAL
	 */
	static <T> ProblemSolver lookup(final Solution<T> algorithm) {
		return SEQUENTIAL;
	}

	public abstract <T> void solveAll(final List<Solution<T>> algorithms, final T problem)
			throws AlgorithmException
			;

}