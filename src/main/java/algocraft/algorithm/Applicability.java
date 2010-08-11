package algocraft.algorithm;

/**
 * The interface to determine the applicability condition of the algorithm.
 * 
 * @author yujunliang
 * 
 * @param <T>
 */
public interface Applicability<T> {

	/**
	 * If an algorithm implements this interface, this method is used to specify
	 * whether the algorithm is applicable. If an algorithm is applicable on any
	 * condition, there is no need to implement this interface.
	 * 
	 * @param problem
	 * @return whether the algorithm is applicable according to specified
	 *         condition.
	 */
	boolean isApplicable(final T problem);
}
