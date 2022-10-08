package racing.manager;

import racing.car.RacingCar;
import racing.information.RacingInfo;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarManager {

    public RacingCarManager(RacingInfo racingInfo) {
        IntStream.range(0, racingInfo.getCarCount())
                .mapToObj(RacingCar::new)
                .forEach(this::addRacingCar);
    }

    private final List<RacingCar> racingCars = new ArrayList<>();

    public int getCarCount() {
        return racingCars.size();
    }

    public void addRacingCar(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    public void forwardCars() {
        racingCars.forEach(rc -> rc.forward(RandomUtils.getRandomInteger()));
    }
}
