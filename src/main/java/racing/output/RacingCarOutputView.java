package racing.output;

public class RacingCarOutputView {
    private static final String MOVE_MARK = "-";

    public void printRacingCarMove(int id, int position) {
        System.out.print(id + ": ");
        for (int i = 0; i < position; i++) {
            System.out.print(MOVE_MARK);
        }
        System.out.println();
    }
}
