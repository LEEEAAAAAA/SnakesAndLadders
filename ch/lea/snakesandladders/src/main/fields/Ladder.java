package ch.lea.snakesandladders.src.main.fields;

public class Ladder extends Field {
    public Ladder(int start, int end) {
        super(start, end);
        checkIfLadder(start, end);
    }

    private void checkIfLadder(int start, int end){
        if (start >= end) {
            throw new IllegalArgumentException(
                    "Ladder must ascend"
            );
        }
    }
}
