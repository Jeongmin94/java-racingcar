package calculator;

import utils.StringToNumberUtils;

import java.util.Arrays;

import static utils.StringSplitUtils.stringToNumbers;

public class StringAddCalculator {

    public int calculate(String value) {
        String[] numbers = stringToNumbers(value);
        PositiveNumbers positiveNumbers = new PositiveNumbers();

        Arrays.stream(numbers)
                .map(StringToNumberUtils::parseInt)
                .forEach(positiveNumbers::addNumber);
        return positiveNumbers.sum();
    }
}
