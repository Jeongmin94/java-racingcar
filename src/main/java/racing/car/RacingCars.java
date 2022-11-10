package racing.car;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            racingCars.add(new RacingCar());
        }
    }

    public void forward() {
        racingCars.forEach(car -> car.moveForward(RandomUtils.getRandomInteger()));
    }

    public int getCarPos(int idx) {
        return racingCars.get(idx).getPosition();
    }

    public int cars() {
        return racingCars.size();
    }
}
