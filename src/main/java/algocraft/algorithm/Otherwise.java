package algocraft.algorithm;

import com.google.common.base.Predicate;

/**
 * 
 * This interface specify the alternative logic if the main logic is not
 * applicable. It is the else block if using if-else pattern.
 * 
 * @author yujunliang
 * 
 * @param <T>
 */
public interface Otherwise<T> extends Predicate<T> {

	/**
	 * if the main logic is not applicable, execute this logic.
	 * 
	 * @param problem
	 */
	void otherwise(final T problem);

}
