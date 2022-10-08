package racing.manager;

import racing.information.RacingInfo;
import racing.output.RacingOutputView;

public class RacingManager {
    private final RacingCarManager racingCarManager;
    private final RacingInfo racingInfo;

    public RacingManager(RacingInfo racingInfo) {
        this.racingInfo = racingInfo;
        this.racingCarManager = new RacingCarManager(racingInfo);
    }

    public int getCarCount() {
        return racingCarManager.getCarCount();
    }

    public int getRaceCount() {
        return racingInfo.getRaceCount();
    }

    public void forwardCars() {
        RacingOutputView.forwardCars(racingInfo.getRaceCount(), racingCarManager);
    }
}
