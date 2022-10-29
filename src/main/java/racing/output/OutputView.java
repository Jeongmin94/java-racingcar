package racing.output;

import racing.manager.RacingCarManager;
import utils.RandomUtils;

import java.util.stream.IntStream;

public class OutputView {

    private static final String MOVE_MARK = "-";

    private final int carCount;
    private final int raceCount;

    public OutputView(int carCount, int raceCount) {
        this.carCount = carCount;
        this.raceCount = raceCount;
    }

    public void race(RacingCarManager rm) {
        System.out.println("실행 결과");
        for (int race = 0; race < raceCount; race++) {
            rm.forward(RandomUtils.getRandomIntegerList(carCount));
            System.out.println();
            print(rm, carCount);
        }
    }

    private void print(RacingCarManager rm, int carCount) {
        IntStream.range(0, carCount)
                .forEach(id -> printRacingCarMove(id, rm.getCarPositionOf(id)));
    }

    private void printRacingCarMove(int id, int position) {
        System.out.print(id + ": ");
        for (int i = 0; i < position; i++) {
            System.out.print(MOVE_MARK);
        }
        System.out.println();
    }
}
