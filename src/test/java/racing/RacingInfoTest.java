package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingInfoTest {
    private static final String TEST_CAR_COUNT = "5";
    private static final String TEST_RACE_COUNT = "3";
    private final RacingInfo testRacingInfo = new RacingInfo(TEST_CAR_COUNT, TEST_RACE_COUNT);

    @DisplayName("RacingInfo 인스턴스 생성 테스트")
    @Test
    void racingInfoConstructorTest() {
        RacingInfo racingInfo = new RacingInfo(TEST_CAR_COUNT, TEST_RACE_COUNT);
        assertThat(racingInfo.equals(testRacingInfo)).isTrue();
    }

    @DisplayName("RacingInfo 인스턴스 생성시 NumberFormatException 발생 테스트")
    @Test
    void racingInfoConstructorWithExceptionTest() {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> new RacingInfo(TEST_CAR_COUNT, "잘못된 raceCount"))
                .withMessageContaining("number는 정수가 아닙니다.");
    }
}