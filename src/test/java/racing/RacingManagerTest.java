package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.information.RacingInfo;
import racing.manager.RacingManager;

import static org.assertj.core.api.Assertions.assertThat;

class RacingManagerTest {
    private static final int TEST_CAR_COUNT = 5;
    private static final int TEST_RACE_COUNT = 3;

    private final RacingManager rm =
            new RacingManager(new RacingInfo(Integer.toString(TEST_CAR_COUNT), Integer.toString(TEST_RACE_COUNT)));

    @DisplayName("RacingManager 이니셜라이징 테스트")
    @Test
    void initRacingManagerTest() {
        assertThat(rm.getCarCount()).isEqualTo(TEST_CAR_COUNT);
        assertThat(rm.getRaceCount()).isEqualTo(TEST_RACE_COUNT);
    }
}