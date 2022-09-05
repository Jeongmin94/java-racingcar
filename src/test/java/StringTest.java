import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @DisplayName("split 메서드 사용해서 문자열 자르기")
    @Test
    void splitTest() {
        String splitDelim = ",";
        String oneTwo = "1,2";
        String one = "1";

        String[] oneTwoArr = oneTwo.split(splitDelim);
        String[] oneArr = one.split(splitDelim);

        assertThat(oneTwoArr).hasSize(2);
        assertThat(oneArr).hasSize(1);

        assertThat(oneTwoArr).contains("1", "2");
        assertThat(oneArr).containsExactly("1");
    }

    @DisplayName("substring 메서드 사용해서 문자열의 괄호 제거하기")
    @Test
    void substringTest() {
        String oneTwoWithBracket = "(1,2)";

        String oneTwo = oneTwoWithBracket.substring(1, oneTwoWithBracket.indexOf(")"));

        assertThat(oneTwo).isEqualTo("1,2");
    }

    @DisplayName("charAt 메서드 사용해서 문자열의 특정 문자 위치 가져오기")
    @Test
    void charAtTest() {
        String abc = "abc";

        assertThat(charAtWithCustomExceptionMessage(abc, 0)).isEqualTo('a');
        assertThat(charAtWithCustomExceptionMessage(abc, 1)).isEqualTo('b');
        assertThat(charAtWithCustomExceptionMessage(abc, 2)).isEqualTo('c');
    }

    @DisplayName("[assertThatThrownBy] 문자열의 길이를 초과하는 charAt 메서드 사용시 발생하는 exception 테스트")
    @Test
    void charIndexOutOfBoundTest_AssertThatThrownByTest() {
        String abc = "abc";
        int outOfRangeInteger = 3;

        assertThat(abc).hasSize(3);
        assertThat(abc.charAt(0)).isEqualTo('a');

        assertThatThrownBy(() -> charAtWithCustomExceptionMessage(abc, outOfRangeInteger))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("최소인덱스")
                .hasMessageContaining("최대인덱스")
                .hasMessageContaining("입력인덱스");
    }

    @DisplayName("[assertThatExceptionOfType] 문자열의 길이를 초과하는 charAt 메서드 사용시 발생하는 exception 테스트")
    @Test
    void charIndexOutOfBoundTest_AssertThatExceptionOfTypeTest() {
        String abc = "abc";
        int outOfRangeInteger = 3;

        assertThat(abc).hasSize(3);
        assertThat(abc.charAt(0)).isEqualTo('a');

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> charAtWithCustomExceptionMessage(abc, outOfRangeInteger))
                .withMessageContaining("최소인덱스")
                .withMessageContaining("최대인덱스")
                .withMessageContaining("입력인덱스");
    }

    /**
     * StringIndexOutOfBoundsException의 메시지에 문자열의 인덱스 정보 포함
     *
     * @param value charAt 메서드를 실행할 문자열
     * @param index charAt 메서드의 매개변수
     * @return
     */
    private char charAtWithCustomExceptionMessage(String value, int index) {
        try {
            return value.charAt(index);
        } catch (RuntimeException e) {
            throw new StringIndexOutOfBoundsException(String.format("최소인덱스: %d 최대인덱스: %d 입력인덱스: %d", 0, value.length() - 1, index));
        }
    }
}
