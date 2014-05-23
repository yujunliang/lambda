package algocraft.function;


import java.util.function.Function;

import static com.google.common.base.Joiner.on;
import static java.util.stream.Stream.of;

public class StringUtil {

    public static String revert(CharSequence string) {
        char[] chars = string.toString().toCharArray();
        revertWords(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    public static String revertWords(String string) {
        String[] strings = string.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static char[] revertWords(char[] string) {
        int start = 0;
        int end = string.length - 1;
        revertWords(string, start, end);

        int current = 0;
        while (current < end && string[current++] != ' ') {
            if (string[current] == ' ') {
                revertWords(string, start, current-1);
                start = ++current;
            }
        }
        revertWords(string, start, end);
        return string;
    }

    public static void revertWords(char[] string, int start, int end) {
        char temp;
        while (end > start) {
            temp = string[start];
            string[start++] = string[end];
            string[end--] = temp;
        }
    }

    static CharSequence removeLastChar(CharSequence sb) {
        return sb.subSequence(0, sb.length() - 1);
    }

    static <P> StringBuilder stringify(P[] values, Function<P, CharSequence> consumer) {
        StringBuilder sb = new StringBuilder();
        of(values).forEach(value -> sb.append(consumer.apply(value)));
        return sb;
    }

    public static CharSequence concatenate(Object... parts) {
        return new CharSequence() {

            String desc1;

            @Override
            public int length() {
                return toString().length();
            }

            @Override
            public char charAt(int index) {
                return toString().charAt(index);
            }

            @Override
            public CharSequence subSequence(int start, int end) {
                return toString().subSequence(start,end);
            }

            @Override
            public String toString() {
                if (desc1 == null) {
                    desc1 = on("").join(parts);
                }
                return desc1;
            }
        };
    }

    public static CharSequence format(String string, Object... parts) {
        return new CharSequence() {

            String desc1;

            @Override
            public int length() {
                return toString().length();
            }

            @Override
            public char charAt(int index) {
                return toString().charAt(index);
            }

            @Override
            public CharSequence subSequence(int start, int end) {
                return toString().subSequence(start,end);
            }

            @Override
            public String toString() {
                if (desc1 == null) {
                    desc1 = String.format(string, parts);
                }
                return desc1;
            }
        };
    }

}
