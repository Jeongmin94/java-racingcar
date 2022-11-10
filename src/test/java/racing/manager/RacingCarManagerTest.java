package racing.manager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarManagerTest {

    private static final int TEST_ID = 1;
    private static final int TEST_CAR_COUNT = 2;

    @DisplayName("RacingCars 생성 테스트")
    @Test
    void constructRacingCarManagerTest() {
        RacingCarManager rm = new RacingCarManager(TEST_CAR_COUNT);
        assertThat(rm).isEqualTo(new RacingCarManager(TEST_CAR_COUNT));
    }
}
