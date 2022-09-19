package racing;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingCarManager {
    private static final int STANDARD_FOR_MOVE = 4;
    private final List<RacingCar> racingCars = new ArrayList<>();

    public int getCarCount() {
        return racingCars.size();
    }

    public void addRacingCar(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    public void forwardCars() {
        racingCars.forEach(rc -> {
            if (RandomUtils.getRandomInteger() >= STANDARD_FOR_MOVE) {
                rc.forward();
            }
            rc.printMoveMark();
        });
        System.out.println();
    }
}
