package minigames.drawing;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode
public class Symbol {
    public static final int AMOUNT_COLUMNS = 4;
    public static final int AMOUNT_ROWS = 4;

    public static final Symbol defaultSymbol = new Symbol(new boolean[][] {{false, false, false, false},
                                                                           {false, false, false, false},
                                                                           {false, false, false, false},
                                                                           {false, false, false, false}
    });

    private boolean[][] appearance;

    public boolean[][] getAppearance() {
        return appearance;
    }

    public Symbol(@NonNull boolean[][] appearance) {
        if(appearance.length != AMOUNT_ROWS || appearance[0].length != AMOUNT_COLUMNS)
            throw new IllegalArgumentException("input massive is not correct");
        this.appearance = appearance;
    }

    public Symbol() {

    }

}
