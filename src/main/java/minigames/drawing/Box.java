package minigames.drawing;

import lombok.NonNull;
import lombok.Setter;

@Setter
public class Box {
    private String nameGoods;


    public String getNameGoods() {
        return nameGoods;
    }

    private Symbol[] correctSymbols;

    public Symbol[] getCorrectSymbols() {
        return correctSymbols;
    }


    private Symbol inflictedSymbol;

    public Symbol getInflictedSymbol() {
        return inflictedSymbol;
    }

    public void setInflictedSymbol(@NonNull Symbol inflictedSymbol) {
        this.inflictedSymbol = inflictedSymbol;
    }

    public Box(String nameGoods, @NonNull Symbol[] correctSymbols) {
        if(isCorrectSymbolsEmpty(correctSymbols))
            throw new IllegalArgumentException("correct Symbols are Empty");

        this.nameGoods = nameGoods;
        this.correctSymbols = correctSymbols;
        this.inflictedSymbol = Symbol.defaultSymbol;
    }

    public Box() {

    }

    private boolean isCorrectSymbolsEmpty(Symbol[] correctSymbols){
        for(Symbol i : correctSymbols){

            if(i != null)
                return false;
    }

        return true;
    }
}
