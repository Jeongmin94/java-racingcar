package racing.output;

import racing.car.RacingCars;

public class OutputView {

    private static final String MOVE_MARK = "-";

    public void initRace() {
        System.out.println("실행 결과");
    }

    private void printEmpty() {
        System.out.println();
    }

    public void race(RacingCars racingCars) {
        printEmpty();
        for (int i = 0; i < racingCars.cars(); i++) {
            printRacingCarMove(i, racingCars.getCarPos(i));
            printEmpty();
        }
    }

    private void printRacingCarMove(int id, int position) {
        System.out.print(id + ": ");
        for (int i = 0; i < position; i++) {
            System.out.print(MOVE_MARK);
        }
    }
}
