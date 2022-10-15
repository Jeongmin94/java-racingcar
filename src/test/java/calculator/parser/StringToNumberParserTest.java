package calculator.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.StringToNumberUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringToNumberParserTest {

    private static final String TEST_STRING_NUMBER = "11";
    private static final String TEST_STRING = "A";

    @DisplayName("문자열을 숫자로 파싱하기 테스트")
    @Test
    void parseIntTest() {
        int actual = StringToNumberUtils.parseInt(TEST_STRING_NUMBER);
        assertThat(actual).isEqualTo(11);
    }

    @DisplayName("알파벳을 파싱할 때 예외 테스트")
    @Test
    void parseAlphabetTest() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> StringToNumberUtils.parseInt(TEST_STRING))
                .withMessageContaining("정수가 아닙니다.");
    }
}