package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PositiveNumbersTest {

    private static final int TEST_POSITIVE_NUMBER = 10;
    private static final int TEST_MINUS_NUMBER = -10;

    private final PositiveNumbers positiveNumbers = new PositiveNumbers();

    @DisplayName("합 구하기 테스트")
    @Test
    void addNumTest() {
        int expect = 0;
        for (int i = 1; i <= 10; i++) {
            expect += i;
            positiveNumbers.addNumber(i);
        }
        int actual = positiveNumbers.sum();
        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("음수를 추가할 때 예외 테스트")
    @Test
    void addMinusNumTest() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> positiveNumbers.addNumber(TEST_MINUS_NUMBER))
                .withMessageContaining("음수입니다.");
    }
}