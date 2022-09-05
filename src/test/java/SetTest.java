import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size 메서드 사용해서 set의 크기를 확인")
    @Test
    void sizeTest() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("set의 contains 메서드를 사용해서 ValueSource의 값이 포함되어 있는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsValueSourceTest(int value) {
        assertThat(numbers).contains(value);
    }

    @DisplayName("set의 contains 메서드를 사용해서 특정 값이 포함되어 있는지 실제 결과와 예측값을 비교하여 확인")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsCsvSourceTest(int value, boolean expect) {
        boolean actual = numbers.contains(value);
        assertThat(actual).isEqualTo(expect);
    }
}
