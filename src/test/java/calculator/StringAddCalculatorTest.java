package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    private final StringAddCalculator calculator = new StringAddCalculator();

    @DisplayName("기본 구분자(쉼표, 콜론)으로 문자열 분리 테스트")
    @Test
    void splitByDefaultDelimTest() {
        String value = "1:2,3";
        String defaultDelim = ",|:";

        String[] actual = value.split(defaultDelim);

        assertThat(actual).hasSize(3);
    }

    @DisplayName("기본 구분자로 문자열 덧셈 테스트")
    @Test
    void defaultDelimCalculateTest() {
        String value = "1:2,3";

        int actual = calculator.calculate(value);

        assertThat(actual).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자와 문자열 분리 테스트")
    @Test
    void splitByCustomDelimTest() {
        String value = "//;\\n1;2;3";
        String regex = "(\\/\\/)(.+)(\\\\n)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        if (matcher.find()) {
            assertThat(matcher.group(1)).isEqualTo("//");
            assertThat(matcher.group(2)).isEqualTo(";");
            assertThat(matcher.group(3)).isEqualTo("\\n");
        }
    }

    @DisplayName("커스텀 구분자를 사용한 문자열 덧셈 테스트")
    @Test
    void customDelimCalculateTest() {
        String value = "//;\\n1;2;3";

        int actual = calculator.calculate(value);

        assertThat(actual).isEqualTo(6);
    }

    @DisplayName("문자열에 숫자가 아닌 문자가 들어있는 경우 RuntimeException throw 테스트")
    @Test
    void throwRuntimeExceptionTest() {
        String value = "//;\\n1;2;a";

        assertThatThrownBy(() -> calculator.calculate(value)).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("정수 변환 오류");
    }
}