package algocraft.cache;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Collection;

public class TwoKeySelfPopulatingCache<R, C, V> {

    private final int maxRow;
    private final int maxColumn;
    private final TwoKeyCachePolicy<R, C> twoKeyCachePolicy;
    private final Creator<R, C, V> creator;
    private final Table<R, C, V> cache = HashBasedTable.create();

    public TwoKeySelfPopulatingCache(int maxRow, int maxColumn, TwoKeyCachePolicy<R, C> twoKeyLRUPolicy, Creator<R, C, V> creator) {
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
        this.twoKeyCachePolicy = twoKeyLRUPolicy;
        this.creator = creator;
    }

    public static <R, C, V> TwoKeySelfPopulatingCache<R, C, V> create(Creator<R, C, V> creator) {
        return create(3, 3, new TwoKeyLRUPolicy(), creator);
    }

    public static <R, C, V> TwoKeySelfPopulatingCache<R, C, V> create(int maxRow, int maxColumn, TwoKeyCachePolicy<R, C> twoKeyCachePolicy, Creator<R, C, V> creator) {
        return new TwoKeySelfPopulatingCache<>(maxRow, maxColumn, twoKeyCachePolicy, creator);
    }

    public synchronized V valueOf(R row, C column) {

        if (maxColumn - cache.columnKeySet().size() >= maxRow - cache.rowKeySet().size()) {
            evictRow(row);
            evictColumn(column);
        } else {
            evictColumn(column);
            evictRow(row);
        }
        V value = cache.get(row, column);
        if (value == null) {
            value = creator.create(row, column);
            if (value != null) {
                cache.put(row, column, value);
            }
        }
        return value;
    }

    private void evictColumn(C column) {
        C evictingColumn = twoKeyCachePolicy.evictingColumnKey(cache.columnKeySet().size() == maxColumn, column);
        if (evictingColumn != null) {
            cache.column(evictingColumn).clear();
        }
    }

    private void evictRow(R row) {
        R evictingRow = twoKeyCachePolicy.evictingRowKey(cache.rowKeySet().size() == maxRow, row);
        if (evictingRow != null) {
            cache.row(evictingRow).clear();
        }
    }

    public Collection<V> values() {
        return cache.values();
    }

    public interface Creator<R, C, V> {
        V create(R row, C column);
    }
}
