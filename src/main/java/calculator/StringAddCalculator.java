package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern EXTRACT_CUSTOM_DELIM_PATTERN = Pattern.compile("(\\/\\/)(.+)(\\\\n)");
    private static final String DEFAULT_DELIM = ":|,";
    private static final String CUSTOM_DELIM_PARTITION = "\\n";

    public int calculate(String value) throws RuntimeException {
        String delim = DEFAULT_DELIM;

        Matcher customDelimMatcher = EXTRACT_CUSTOM_DELIM_PATTERN.matcher(value);
        if (hasCustomDelim(customDelimMatcher)) {
            delim = delim + "|" + extractCustomDelim(customDelimMatcher);
            value = value.substring(value.indexOf(CUSTOM_DELIM_PARTITION) + 2);
        }

        String[] split = value.split(delim);

        return Arrays.stream(split)
                .map(it -> {
                    try {
                        return Integer.parseInt(it);
                    } catch (NumberFormatException e) {
                        throw new RuntimeException("정수 변환 오류. 숫자를 입력해야 합니다.");
                    }
                })
                .mapToInt(Integer::intValue)
                .sum();
    }

    private String extractCustomDelim(Matcher customDelimMatcher) {
        return customDelimMatcher.group(2);
    }

    private boolean hasCustomDelim(Matcher customDelimMatcher) {
        return customDelimMatcher.find();
    }
}
