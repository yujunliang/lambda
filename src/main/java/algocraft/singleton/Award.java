package algocraft.singleton;


import algocraft.cache.SelfPopulatingCache;

import java.util.Collection;

import static algocraft.cache.SelfPopulatingCache.create;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang.builder.ToStringStyle.SHORT_PREFIX_STYLE;

/**
 * Dynamic enum type of Award class
 */
public class Award {

    private final static SelfPopulatingCache<Integer, Award> AWARDS = create(Award::new);

    public final int level;

    private Award(int level) {
        this.level = level;
    }

    /**
     * @param level
     * @return existing or newly created instance
     */
    public static Award valueOf(int level) {
        return AWARDS.valueOf(level);
    }

    /**
     * @return all cached instances in a collection
     */
    public static Collection<Award> values() {
        return AWARDS.values();
    }

    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }

    @Override
    public int hashCode() {
        return level;
    }

    @Override
    public boolean equals(Object that) {
        return (this == that) || (that instanceof Award) && equals((Award) that);
    }

    public boolean equals(Award that) {
        return that.level == this.level;
    }

}
