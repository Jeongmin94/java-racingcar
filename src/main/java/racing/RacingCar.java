package racing;

public class RacingCar {
    private static final String MOVE_MARK = "-";

    private final int id;
    private int position;

    public RacingCar(int id) {
        this.id = id;
        this.position = 0;
    }

    public void forward() {
        position++;
    }

    public void printMoveMark() {
        System.out.print(id + ": ");
        for (int i = 0; i < position; i++) {
            System.out.print(MOVE_MARK);
        }
        System.out.println();
    }
}
