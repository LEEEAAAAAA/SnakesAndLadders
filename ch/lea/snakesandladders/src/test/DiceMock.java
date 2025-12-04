package ch.lea.snakesandladders.src.test;

import ch.lea.snakesandladders.src.main.Dice;

public class DiceMock implements Dice {
    private  int fixedValue;

    public DiceMock(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    public void setFixedValue(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int roll() {
        return fixedValue;
    }
}