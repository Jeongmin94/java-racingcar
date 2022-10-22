package calculator;

import java.util.ArrayList;
import java.util.List;

public class PositiveNumbers {

    private final List<Integer> numbers = new ArrayList<>();

    public void addNumber(int number) {
        if (number < 0) {
            throw new RuntimeException(String.format("음수 계산 불가. %d는 음수입니다.", number));
        }
        numbers.add(number);
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int getNumbersSize() {
        return numbers.size();
    }
}
