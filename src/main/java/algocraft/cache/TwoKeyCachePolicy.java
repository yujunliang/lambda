package algocraft.cache;


public interface TwoKeyCachePolicy<R, C> {
    R evictingRowKey(boolean cacheIsFull, R key);
    C evictingColumnKey(boolean cacheIsFull, C key);
}
