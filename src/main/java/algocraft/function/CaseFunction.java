package algocraft.function;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;

import java.util.Map;


public class CaseFunction<T1, T2, V> implements Function<T1, T2> {
    private final Map<V, Function<T1, T2>> functionMap;
    private final Function<T1, V> discriminator;

    public CaseFunction(Function<T1, V> discriminator, V value1, Function<T1, T2> f1, V value2, Function<T1, T2> f2, V value3, Function<T1, T2> f3) {
        this.discriminator = discriminator;
        functionMap = ImmutableMap.of(value1, f1, value2, f2, value3, f3);
    }

    public CaseFunction(Function<T1, V> discriminator, Map<V, Function<T1, T2>> map) {
        this.discriminator = discriminator;
        this.functionMap = map;
    }

    @Override
    public T2 apply(T1 t1) {
        return functionMap.get(discriminator.apply(t1)).apply(t1);
    }
}
