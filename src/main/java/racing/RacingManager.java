package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingManager {
    private final List<RacingCar> racingCars = new ArrayList<>();
    private final RacingInfo racingInfo;

    public RacingManager(RacingInfo racingInfo) {
        initRacingCars(racingInfo.getCarCount());
        this.racingInfo = racingInfo;
    }

    public void initRacingCars(int carCount) {
        IntStream.range(0, carCount)
                .mapToObj(RacingCar::new)
                .forEach(racingCars::add);
    }

    public int getCarCount() {
        return racingCars.size();
    }

    public int getRaceCount() {
        return racingInfo.getRaceCount();
    }
}
