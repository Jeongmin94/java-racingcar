package racing.manager;

import racing.car.RacingCars;

public class RacingCarManager {

    private final RacingCars racingCars;

    public RacingCarManager(int carCount) {
        racingCars = new RacingCars(carCount);
    }

    public void forward() {
        racingCars.forward();
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}
