package racing.output;

import racing.manager.RacingCarManager;

public class RacingOutputView {

    public static void forwardCars(int rounds, RacingCarManager rm) {
        System.out.println("실행 결과");
        for (int i = 0; i < rounds; i++) {
            rm.forwardCars();
            System.out.println();
        }
    }
}
