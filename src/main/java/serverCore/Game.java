package serverCore;

import lombok.NonNull;

public class Game {
    private String description;

    public String getDescription() {
        return description;
    }

    public enum Games{
        APPLE_THEFT(0), CHOOSE_FATE(1), DRAW_RUNS(2), DRINKERS(3), SEQUENCE(4);

        private int numberOfGame;

        public int getNumberOfGame() {
            return numberOfGame;
        }

        Games(int numberOfGame) {
            this.numberOfGame = numberOfGame;
        }
    }

    Games game;

    public Games getGame() {
        return game;
    }

    public static final int AMOUNT_BOX_FOR_ONE_GAME = 3;

    public Game(@NonNull String description, @NonNull Games game) {
        this.description = description;
        this.game = game;
    }
    public Game(){

    }
}

