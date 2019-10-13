package minigames.loby;

import lombok.NonNull;

public class Game {
    private String description;

    public String getDescription() {
        return description;
    }

    public enum Games{
        APPLE_THEFT(1), CHOOSE_FATE(2), DRAW_RUNS(3), DRINKERS(4), SEQUENCE(5);

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

    public Game(@NonNull String description, @NonNull Games game) {
        this.description = description;
        this.game = game;
    }
}

