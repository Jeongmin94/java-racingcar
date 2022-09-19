package racing;

import java.util.stream.IntStream;

public class RacingManager {
    private final RacingCarManager racingCarManager = new RacingCarManager();
    private final RacingInfo racingInfo;

    public RacingManager(RacingInfo racingInfo) {
        this.racingInfo = racingInfo;
        initRacingCarManager(racingInfo);
    }

    public void initRacingCarManager(RacingInfo racingInfo) {
        IntStream.range(0, racingInfo.getCarCount())
                .mapToObj(RacingCar::new)
                .forEach(racingCarManager::addRacingCar);
    }

    public int getCarCount() {
        return racingCarManager.getCarCount();
    }

    public int getRaceCount() {
        return racingInfo.getRaceCount();
    }

    public void forwardCars() {
        System.out.println("실행 결과");
        for (int i = 0; i < racingInfo.getRaceCount(); i++) {
            racingCarManager.forwardCars();
        }
    }
}
