package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitUtils {
    private static final Pattern EXTRACT_CUSTOM_DELIM_PATTERN = Pattern.compile("(\\/\\/)(.+)(\\\\n)(.*)");
    private static final String DEFAULT_DELIM = ":|,";
    private static final String DELIM_PARTITION = "|";
    private static final int CUSTOM_DELIM_REGEX_GROUP = 2;
    private static final int NUMBERS_REGEX_GROUP = 4;

    private StringSplitUtils() {
    }

    public static String[] stringToNumbers(String value) {
        String delim = extractDelim(value);
        String numbersWithDelim = extractNumbersWithDelim(value);

        return numbersWithDelim.split(delim);
    }

    public static String extractDelim(String value) {
        return extractDelim(EXTRACT_CUSTOM_DELIM_PATTERN.matcher(value));
    }

    public static String extractDelim(Matcher matcher) {
        if (hasCustomDelim(matcher)) {
            return DEFAULT_DELIM + DELIM_PARTITION + extractCustomDelim(matcher);
        }
        return DEFAULT_DELIM;
    }

    public static String extractNumbersWithDelim(String value) {
        Matcher matcher = EXTRACT_CUSTOM_DELIM_PATTERN.matcher(value);
        if (hasCustomDelim(matcher)) {
            return matcher.group(NUMBERS_REGEX_GROUP);
        }
        return value;
    }

    public static boolean hasCustomDelim(String value) {
        return hasCustomDelim(EXTRACT_CUSTOM_DELIM_PATTERN.matcher(value));
    }

    public static boolean hasCustomDelim(Matcher matcher) {
        return matcher.find();
    }

    private static String extractCustomDelim(String value) {
        return extractCustomDelim(EXTRACT_CUSTOM_DELIM_PATTERN.matcher(value));
    }

    private static String extractCustomDelim(Matcher matcher) {
        return matcher.group(CUSTOM_DELIM_REGEX_GROUP);
    }
}
