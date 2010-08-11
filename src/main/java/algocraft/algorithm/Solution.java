package algocraft.algorithm;


/**
 * Solution for a single problem not requiring loop.
 * 
 * @author yujunliang
 * 
 * @param <T>
 */
public interface Solution<T>  {

	/**
	 * Solve the problem
	 * 
	 * @param problem
	 * @throws Exception
	 */
	void solve(final T problem) throws AlgorithmException;

}
