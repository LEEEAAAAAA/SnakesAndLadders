package ch.lea.snakesandladders.src.main.fields;

public class Snake extends Field {
    public Snake(int start, int end) {
        super(start, end);
        checkIfSnake(start, end);
    }

    private void checkIfSnake(int start, int end){
        if (start <= end) {
            throw new IllegalArgumentException(
                    "Snake must descend"
            );
        }
    }
}
