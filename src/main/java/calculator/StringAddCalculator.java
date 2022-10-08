package calculator;

import calculator.parser.ToNumberParser;

import java.util.Arrays;

import static utils.StringSplitUtils.stringToNumbers;

public class StringAddCalculator {

    private final ToNumberParser parser;

    public StringAddCalculator(ToNumberParser parser) {
        this.parser = parser;
    }

    public int calculate(String value) {
        String[] numbers = stringToNumbers(value);

        return Arrays.stream(numbers)
                .map(parser::parseInt)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
