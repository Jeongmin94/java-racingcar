package calculator;

import java.util.Arrays;

import static utils.StringSplitUtils.stringToNumbers;

public class StringAddCalculator {
    public int calculate(String value) {
        String[] numbers = stringToNumbers(value);

        return Arrays.stream(numbers)
                .map(StringAddCalculator::parseInt)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static Integer parseInt(String number) {
        int parseNum;
        try {
            parseNum = Integer.parseInt(number);
        } catch (RuntimeException e) {
            throw new RuntimeException(String.format("정수 변환 오류. %s는 정수가 아닙니다.", number));
        }

        if (parseNum < 0) {
            throw new RuntimeException(String.format("음수 계산 불가. %d는 음수입니다.", parseNum));
        }
        return parseNum;
    }
}
