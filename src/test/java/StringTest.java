import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("split 메서드 사용해서 문자열 자르기")
    @Test
    public void splitTest() {
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
    public void substringTest() {
        String oneTwoWithBracket = "(1,2)";

        String oneTwo = oneTwoWithBracket.substring(1, oneTwoWithBracket.indexOf(")"));

        assertThat(oneTwo).isEqualTo("1,2");
    }

    @DisplayName("charAt 메서드 사용해서 문자열의 특정 문자 위치 가져오기")
    @Test
    public void charAtTest() {
        String abc = "abc";

        assertThat(abc.charAt(0)).isEqualTo('a');
        assertThat(abc.charAt(1)).isEqualTo('b');
        assertThat(abc.charAt(2)).isEqualTo('c');
    }

    @DisplayName("charAt 메서드 사용했을 때 예외 처리")
    @Test
    public void charAtWithStringIndexOutOfBoundsExceptionTest() {
        String abc = "abc";

        assertThat(abc.length()).isEqualTo(3);
        assertThat(abc.charAt(0)).isEqualTo('a');

        assertThatThrownBy(() -> abc.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("out of range: 3");
    }
}
