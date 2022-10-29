package racing.manager;

import racing.car.RacingCar;
import racing.exception.RandomIntegerOutOfRangeException;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarManager {

    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingCarManager(int carCount) {
        IntStream.range(0, carCount)
                .mapToObj(RacingCar::new)
                .forEach(this::addRacingCar);
    }

    private void addRacingCar(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    private void forwardCar(int car, int randomInt) {
        if (!RandomIntegerOutOfRangeException.validateRandomInteger(randomInt)) {
            throw new RandomIntegerOutOfRangeException(StringUtils.getInvalidRandomIntMessage(randomInt));
        }
        racingCars.get(car).moveForward(randomInt);
    }

    public void forward(List<Integer> randoms) {
        for (int car = 0; car < racingCars.size(); car++) {
            forwardCar(car, randoms.get(car));
        }
    }

    public int getCarPositionOf(int idx) {
        return racingCars.get(idx).getPosition();
    }

    public boolean carsCountSameWith(int carCount) {
        return (racingCars.size() == carCount);
    }
}
