package algocraft.cache;

public class TwoKeyLRUPolicy<R, C> implements TwoKeyCachePolicy<R, C> {

    private final OneKeyCachePolicy<R> rowPolicy = new OneKeyLRUPolicy<R>();
    private final OneKeyCachePolicy<C> columnPolicy = new OneKeyLRUPolicy<C>();

    @Override
    public R evictingRowKey(boolean rowIsFull, R key) {
        return rowPolicy.evictingKey(rowIsFull, key);
    }

    @Override
    public C evictingColumnKey(boolean columnIsFull, C key) {
        return columnPolicy.evictingKey(columnIsFull, key);
    }
}
