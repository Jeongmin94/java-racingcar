package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.information.Information;

import static org.assertj.core.api.Assertions.assertThat;

class InformationTest {

    private static final int TEST_PARTICIPANTS = 10;
    private static final int TEST_ROUNDS = 10;

    @DisplayName("equals 오버라이딩 equals true 테스트")
    @Test
    void equalsTrueTest() {
        Information i1 = Information.of(TEST_PARTICIPANTS, TEST_ROUNDS);
        Information i2 = Information.of(TEST_PARTICIPANTS, TEST_ROUNDS);

        assertThat(i1.equals(i2)).isTrue();
    }

    @DisplayName("equals 오버라이딩 equals false 테스트")
    @Test
    void equalsFalseTest() {
        Information i1 = Information.of(TEST_PARTICIPANTS, TEST_ROUNDS);
        Information i2 = Information.of(TEST_PARTICIPANTS, TEST_ROUNDS - 1);

        assertThat(i1.equals(i2)).isFalse();
    }

    @DisplayName("hasCode 서로 같은 경우 오버라이딩 테스트")
    @Test
    void hashCodeOverridingTest() {
        Information i1 = Information.of(TEST_PARTICIPANTS, TEST_ROUNDS);
        Information i2 = Information.of(TEST_PARTICIPANTS, TEST_ROUNDS);

        assertThat(i1.hashCode()).isEqualTo(i2.hashCode());
    }

    @DisplayName("hasCode 서로 다른 경우 오버라이딩 테스트")
    @Test
    void hashCodeDiffOverridingTest() {
        Information i1 = Information.of(TEST_PARTICIPANTS, TEST_ROUNDS);
        Information i2 = Information.of(TEST_PARTICIPANTS, TEST_ROUNDS - 1);

        assertThat(i1.hashCode()).isNotEqualTo(i2.hashCode());
    }
}
