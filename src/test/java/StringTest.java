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

        assertThat(abc.charAt(0)).isEqualTo('a');
        assertThat(abc.charAt(1)).isEqualTo('b');
        assertThat(abc.charAt(2)).isEqualTo('c');
    }

    @DisplayName("주어진 문자열의 길이를 초과하는 지점의 문자를 charAt 메서드를 사용해서 가져올 때 발생하는 exception 테스트")
    @Test
    void charAtWithStringIndexOutOfBoundsExceptionTest() {
        String abc = "abc";
        int outOfRangeInteger = 3;

        assertThat(abc).hasSize(3);
        assertThat(abc.charAt(0)).isEqualTo('a');

        assertThatThrownBy(() -> abc.charAt(outOfRangeInteger))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("out of range: 3");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> abc.charAt(outOfRangeInteger))
                .withMessage("out of range");
    }
}
