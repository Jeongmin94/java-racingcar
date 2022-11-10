package racing.manager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.RandomIntegerOutOfRangeException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingCarManagerTest {

    private static final int TEST_ID = 1;
    private static final int TEST_CAR_COUNT = 2;

    @DisplayName("RacingCars 생성 테스트")
    @Test
    void constructRacingCarManagerTest() {
        RacingCarManager rm = new RacingCarManager(TEST_CAR_COUNT);
        assertThat(rm.carsCountSameWith(TEST_CAR_COUNT)).isTrue();
    }

    @DisplayName("0 ~ 9 범위를 초과하는 랜덤값이 입력됐을 때 예외 테스트")
    @Test
    void forwardIllegalValueTest() {
        RacingCarManager rm = new RacingCarManager(TEST_CAR_COUNT);
        int validValue = 1;
        int illegalValue = 100;

        List<Integer> values = Arrays.asList(validValue, illegalValue);
        assertThatExceptionOfType(RandomIntegerOutOfRangeException.class)
                .isThrownBy(() -> rm.forward(values))
                .withMessageContaining("지정한 범위(0 ~ 9)를 초과했습니다. randomInt: %d", illegalValue);
    }
}
