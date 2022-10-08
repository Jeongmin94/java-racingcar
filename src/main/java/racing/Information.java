package racing;

public class Information {
    private final int participants;
    private final int rounds;

    private Information(int participants, int rounds) {
        this.participants = participants;
        this.rounds = rounds;
    }

    public static Information of(int participants, int rounds) {
        return new Information(participants, rounds);
    }

    public int getParticipants() {
        return participants;
    }

    public int getRounds() {
        return rounds;
    }
}
