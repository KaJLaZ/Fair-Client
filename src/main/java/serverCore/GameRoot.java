package serverCore;

import lombok.NonNull;

public class GameRoot {
    public static final int AMOUNT_BOX_FOR_ONE_GAME = 2;
    Games game;
    private String description;

    public GameRoot(@NonNull String description, @NonNull Games game) {
        this.description = description;
        this.game = game;
    }

    public GameRoot() {

    }

    public String getDescription() {
        return description;
    }

    public Games getGame() {
        return game;
    }

    public enum Games {
        APPLE_THEFT(0), CHOOSE_FATE(1), DRAW_RUNS(2), DRINKERS(3),
        SEQUENCE(4), END_GAME(5);

        private int numberOfGame;

        Games(int numberOfGame) {
            this.numberOfGame = numberOfGame;
        }

        public int getNumberOfGame() {
            return numberOfGame;
        }
    }
}

