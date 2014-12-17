package algocraft.function;

import java.util.HashMap;
import java.util.Map;

import static algocraft.function.ArrayUtil.intArray;
import static algocraft.function.SixFlags.Header.*;
import static algocraft.function.SixFlags.Initializer.init;
import static algocraft.function.SixFlags.Initializer.setup;
import static algocraft.function.StringUtil.*;
import static com.google.common.base.Joiner.on;
import static java.lang.Math.pow;

public enum SixFlags {

    YYYYYY,
    _YYYYY,
    Y_YYYY,
    __YYYY,
    YY_YYY,
    _Y_YYY,
    Y__YYY,
    ___YYY,
    YYY_YY,
    _YY_YY,
    Y_Y_YY,
    __Y_YY,
    YY__YY,
    _Y__YY,
    Y___YY,
    ____YY,
    YYYY_Y,
    _YYY_Y,
    Y_YY_Y,
    __YY_Y,
    YY_Y_Y,
    _Y_Y_Y,
    Y__Y_Y,
    ___Y_Y,
    YYY__Y,
    _YY__Y,
    Y_Y__Y,
    __Y__Y,
    YY___Y,
    _Y___Y,
    Y____Y,
    _____Y,
    YYYYY_,
    _YYYY_,
    Y_YYY_,
    __YYY_,
    YY_YY_,
    _Y_YY_,
    Y__YY_,
    ___YY_,
    YYY_Y_,
    _YY_Y_,
    Y_Y_Y_,
    __Y_Y_,
    YY__Y_,
    _Y__Y_,
    Y___Y_,
    ____Y_,
    YYYY__,
    _YYY__,
    Y_YY__,
    __YY__,
    YY_Y__,
    _Y_Y__,
    Y__Y__,
    ___Y__,
    YYY___,
    _YY___,
    Y_Y___,
    __Y___,
    YY____,
    _Y____,
    Y_____,
    ______;

    /**
     * Format this class and its variables into a table.
     *
     * @return a description of this enum
     */
    public static CharSequence display() {
        return Describer.describe();
    }

    /**
     * @param description the description of the flag and its ordinal is used to index the flag.
     * @return the value of the boolean on the ordinal of the given description enum.
     */
    public boolean valueOf(Enum description) {
        return flags[description.ordinal()];
    }

    /**
     * @param index the index of the flag
     * @return the value of the boolean on the given index.
     */
    public boolean valueAt(int index) {
        return flags[index];
    }

    /**
     * @param description the description of the flag
     * @param flag        the value of the flag
     * @return itself or the flipped instance which has the same value as the given value
     * on the ordinal of the given description enum.
     */
    public SixFlags resolve(Enum description, boolean flag) {
        int ordinal = description.ordinal();
        return flag == flags[ordinal] ? this : flippedFlags[ordinal];
    }

    /**
     * @param index the index of the flag
     * @param flag  the value of the flag
     * @return itself or the flipped instance which has the same value as the given value
     * on the given index.
     */
    public SixFlags resolve(int index, boolean flag) {
        return flag == flags[index] ? this : flippedFlags[index];
    }

    /**
     * Build the following line according to its value,
     * |YYYYYY|0b111111=63|Y|Y|Y|Y|Y|Y|_YYYYY |Y_YYYY |YY_YYY |YYY_YY |YYYY_Y |YYYYY_ |
     *
     * @return the description of this enum constant
     */
    public CharSequence describe() {
        return Describer.describe(this);
    }

    /**
     * Description this instance according to the give description enum instances.
     *
     * @param descriptions the description of each flag
     * @return             the description of this enum constant
     */
    public CharSequence toString(Enum... descriptions) {
        return concatenate("[", Describer.describe(this.flags, descriptions), "]");
    }

    private final boolean[] flags = init(this.name());
    private final SixFlags[] flippedFlags = new SixFlags[flags.length];
    public final CharSequence description = concatenate("[", Describer.describe("flag", flags), "]").toString();

    {
        setup(this);
    }

    static class Header {
        static final CharSequence LINE = "+------+-----------+-----------+-----------------------------------------------+\n";
        static final CharSequence HEADER = concatenate(LINE, "|                  |   flags   |                flippedFlags                   |\n", LINE);
        static final CharSequence HEADER_2 = concatenate("|flag  |key        |", header("|"), header("      |"), "\n");

        static CharSequence header(String filler) {
            return stringify(intArray(YYYYYY.flippedFlags.length), i -> i + filler);
        }

    }

    static class Describer {

        static CharSequence describe() {
            return concatenate(HEADER, HEADER_2, LINE, displayAll(), LINE, HEADER_2, HEADER);
        }

        static CharSequence describe(SixFlags flag) {
            return concatenate("|", flag.name(), "|0b", encodeAll(flag), "=", key(flag), "|", value(flag), "|", flippedFlags(flag), " |\n");
        }

        static CharSequence displayAll() {
            return stringify(SixFlags.values(), SixFlags::describe);
        }

        static CharSequence flippedFlags(SixFlags flag) {
            return on(" |").join(flag.flippedFlags);
        }

        static CharSequence value(SixFlags flag) {
            return on("|").join(flag.name().split(""));
        }

        static CharSequence key(SixFlags flag) {
            int key = Initializer.encodeAll(flag.flags);
            return concatenate((key < 10 ? " " : ""), key);
        }

        static CharSequence encodeAll(SixFlags flag) {
            StringBuilder sb = new StringBuilder();
            for (int i = flag.flags.length - 1; i >= 0; i--) {
                sb.append(flag.flags[i] ? "1" : "0");
            }
            return sb;
        }

        static CharSequence describe(boolean flags[], Enum... indexes) {
            return removeLastChar(stringify(indexes, index -> concatenate(flags[index.ordinal()] ? "" : "!", index, ",")));
        }

        static CharSequence describe(String desc, boolean[] flags) {
            return removeLastChar(stringify(intArray(flags.length), i -> concatenate(flags[i] ? "" : "!", desc + i, ",")));
        }

    }

    static class Initializer {

        static void setup(SixFlags flag) {
            lookup.put(encodeAll(flag.flags), flag);
            if (lookup.size() == pow(2, flag.flags.length)) {
                lookup.keySet().forEach(Initializer::flipFlags);
                lookup.clear();
                lookup = null;
            }
        }

        public static void flipFlags(int key) {
            SixFlags original = lookup.get(key);
            int mask = 1;
            for (int i = 0; i < original.flags.length; i++) {
                int flippedKey = original.flags[i] ? key ^ mask : key | mask;
                mask <<= 1;
                SixFlags flipped = lookup.get(flippedKey);
                original.flippedFlags[i] = flipped;
                flipped.flippedFlags[i] = original;
            }
        }

        static boolean[] init(String name) {
            char[] chars = name.toCharArray();
            boolean[] flags = new boolean[chars.length];
            for (int i = 0; i < chars.length; i++) {
                flags[i] = chars[i] == 'Y';
            }
            return flags;
        }

        static int encodeAll(boolean[] flags) {
            int code = 0;
            int mask = 1;
            for (boolean flag : flags) {
                if (flag) {
                    code |= mask;
                }
                mask <<= 1;
            }
            return code;
        }

        static Map<Integer, SixFlags> lookup = new HashMap<>();

    }
}
