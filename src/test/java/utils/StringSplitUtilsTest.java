package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringSplitUtils.*;

class StringSplitUtilsTest {

    private static final String TEST_NUMBERS_WITH_DEFAULT_DELIM = "1:2,3";
    private static final String TEST_FULL_NUMBERS_WITH_CUSTOM_DELIM = "//;\\n1;2;3";
    private static final String TEST_NUMBERS_WITH_CUSTOM_DELIM = "1;2;3";
    private static final int TEST_NUMBERS_ARRAY_LENGTH = 3;
    private static final String[] TEST_NUMBERS_ARRAY = {"1", "2", "3"};
    private static final String TEST_DEFAULT_DELIM = ":|,";
    private static final String TEST_DELIM_PARTITION = "|";

    @DisplayName("default delim 추출 테스트")
    @Test
    void extractDefaultDelimTest() {
        String delim = extractDelim(TEST_NUMBERS_WITH_DEFAULT_DELIM);

        assertThat(delim).isEqualTo(TEST_DEFAULT_DELIM);
    }

    @DisplayName("custom delim 추출 테스트")
    @Test
    void extractCustomDelimTest() {
        String delim = extractDelim(TEST_FULL_NUMBERS_WITH_CUSTOM_DELIM);

        assertThat(delim).isEqualTo(TEST_DEFAULT_DELIM + TEST_DELIM_PARTITION + ";");
    }

    @DisplayName("문자열에 custom delim이 있는 경우 확인 테스트")
    @Test
    void hasCustomDelimTest() {
        boolean hasCustomDelim = hasCustomDelim(TEST_FULL_NUMBERS_WITH_CUSTOM_DELIM);

        assertThat(hasCustomDelim).isTrue();
    }

    @DisplayName("문자열에 custom delim이 없는 경우 확인 테스트")
    @Test
    void hasNotCustomDelimTest() {
        boolean hasCustomDelim = hasCustomDelim(TEST_NUMBERS_WITH_DEFAULT_DELIM);

        assertThat(hasCustomDelim).isFalse();
    }

    @DisplayName("default delim을 사용할 때 split 할 문자열 추출 테스트")
    @Test
    void extractNumbersWithDelimWhenUseDefaultDelimTest() {
        String numbersWithDelim = extractNumbersWithDelim(TEST_NUMBERS_WITH_DEFAULT_DELIM);

        assertThat(numbersWithDelim).isEqualTo(TEST_NUMBERS_WITH_DEFAULT_DELIM);
    }

    @DisplayName("custom delim을 사용할 때 split 할 문자열 추출 테스트")
    @Test
    void extractNumbersWithDelimWhenUseCustomDelimTest() {
        String numbersWithDelim = extractNumbersWithDelim(TEST_FULL_NUMBERS_WITH_CUSTOM_DELIM);

        assertThat(numbersWithDelim).isEqualTo(TEST_NUMBERS_WITH_CUSTOM_DELIM);
    }

    @DisplayName("default delim이 포함된 문자열을 숫자 문자열로 split 테스트")
    @Test
    void stringToNumbersWhenUseDefaultDelimTest() {
        String[] numbers = stringToNumbers(TEST_NUMBERS_WITH_DEFAULT_DELIM);

        assertThat(numbers).hasSize(TEST_NUMBERS_ARRAY_LENGTH);
        assertThat(numbers).isEqualTo(TEST_NUMBERS_ARRAY);
    }

    @DisplayName("custom delim이 포함된 문자열을 숫자 문자열로 split 테스트")
    @Test
    void stringToNumbersWhenUseCustomDelimTest() {
        String[] numbers = stringToNumbers(TEST_FULL_NUMBERS_WITH_CUSTOM_DELIM);

        assertThat(numbers).hasSize(TEST_NUMBERS_ARRAY_LENGTH);
        assertThat(numbers).isEqualTo(TEST_NUMBERS_ARRAY);
    }
}