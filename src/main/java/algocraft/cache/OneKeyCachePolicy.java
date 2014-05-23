package algocraft.cache;

public interface OneKeyCachePolicy<K> {
    K evictingKey(boolean cacheIsFull, K key);
}
