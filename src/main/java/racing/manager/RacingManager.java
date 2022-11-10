package racing.manager;

public class RacingManager {
    private int raceCount;

    public RacingManager(int raceCount) {
        this.raceCount = raceCount;
    }

    public void decreaseRaceCount() {
        raceCount--;
    }

    public boolean race() {
        return raceCount > 0;
    }
}
