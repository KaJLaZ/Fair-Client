package core;

public class GameContext {
    private boolean hasMoney;

    public boolean isHasMoney() {
        return hasMoney;
    }

    public void setHasMoney(boolean hasMoney) {
        this.hasMoney = hasMoney;
    }

    private String sequence;

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public GameContext() {
        this.hasMoney = false;
    }
}
