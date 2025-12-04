package ch.lea.snakesandladders.src.test;

import ch.lea.snakesandladders.src.main.Dice;

public class DiceMock extends Dice {
    private final int fixedValue;

    public DiceMock(int fixedValue) {
        this.fixedValue = fixedValue;
    }
    @Override
    public int rollDice() {
        return fixedValue;
    }
}