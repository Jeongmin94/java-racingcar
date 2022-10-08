import racing.information.RacingInfo;
import racing.manager.RacingManager;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingInfo racingInfo = RacingInfo.userInputToRacingInfo();
        RacingManager rm = new RacingManager(racingInfo);
        rm.forwardCars();
    }
}
