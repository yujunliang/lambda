package algocraft.function;

/**
 * Created by yujunliang on 4/30/14.
 */
public class ArrayUtil {

    public static Integer[] intArray(int length) {
        Integer[] ints = new Integer[length];
        for (int i = 0; i < length; i++) {
            ints[i] = i;
        }
        return ints;
    }
}
