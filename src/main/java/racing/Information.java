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

    // !TODO getter, setter 폐지 예정
    public int getParticipants() {
        return participants;
    }

    public int getRounds() {
        return rounds;
    }

    private boolean isEqualTo(int participants, int rounds) {
        return (this.participants == participants) && (this.rounds == rounds);
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        return PRIME * result + this.participants + this.rounds;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(obj.getClass() != this.getClass()) {
            return false;
        }
        if(obj == this) {
            return true;
        }
        Information i = (Information) obj;
        return i.isEqualTo(this.participants, this.rounds);
    }
}
