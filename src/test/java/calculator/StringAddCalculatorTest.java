package calculator;

import calculator.parser.StringToNumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringAddCalculatorTest {

    private static final String TEST_NUMBERS_WITH_DEFAULT_DELIM = "1:2,3";
    private static final String TEST_FULL_NUMBERS_WITH_CUSTOM_DELIM = "//;\\n1;2;3";

    private final StringAddCalculator calculator = new StringAddCalculator(new StringToNumberParser());

    @DisplayName("기본 구분자로 문자열 덧셈 테스트")
    @Test
    void defaultDelimCalculateTest() {
        int actual = calculator.calculate(TEST_NUMBERS_WITH_DEFAULT_DELIM);

        assertThat(actual).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자를 사용한 문자열 덧셈 테스트")
    @Test
    void customDelimCalculateTest() {
        int actual = calculator.calculate(TEST_FULL_NUMBERS_WITH_CUSTOM_DELIM);

        assertThat(actual).isEqualTo(6);
    }

    @DisplayName("문자열에 숫자가 아닌 문자가 들어있는 경우 RuntimeException throw 테스트")
    @Test
    void throwRuntimeExceptionWithCharacterTest() {
        String value = "//;\\n1;2;a";

        assertThatThrownBy(() -> calculator.calculate(value)).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("a");
    }

    @DisplayName("문자열에 음수가 들어가 있는 경우 RuntimeException throw 테스트")
    @Test
    void throwRuntimeExceptionWithMinusNumberTest() {
        String value = "//;\\n1;2;-3";

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.calculate(value))
                .withMessageContaining("-3");
    }
}