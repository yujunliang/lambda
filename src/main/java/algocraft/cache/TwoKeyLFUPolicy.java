package algocraft.cache;

public class TwoKeyLFUPolicy<R, C> implements TwoKeyCachePolicy<R, C> {

    private final OneKeyCachePolicy<R> rowPolicy = new OneKeyLFUPolicy<R>();
    private final OneKeyCachePolicy<C> columnPolicy = new OneKeyLFUPolicy<C>();

    @Override
    public R evictingRowKey(boolean rowIsFull, R key) {
        return rowPolicy.evictingKey(rowIsFull, key);
    }

    @Override
    public C evictingColumnKey(boolean columnIsFull, C key) {
        return columnPolicy.evictingKey(columnIsFull, key);
    }
}
