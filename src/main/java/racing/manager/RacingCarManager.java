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

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int res = 1;
        return PRIME * res + racingCars.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if(obj == this) {
            return true;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        RacingCarManager rcm = (RacingCarManager) obj;
        return racingCars.equals(rcm.getRacingCars());
    }
}
