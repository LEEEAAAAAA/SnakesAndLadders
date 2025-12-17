package ch.lea.snakesandladders.src.test;

import ch.lea.snakesandladders.src.main.Dice;

public class DieMock implements Dice {
    private  int fixedValue;

    public DieMock(int fixedValue) {
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