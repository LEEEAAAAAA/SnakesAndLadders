package ch.lea.snakesandladders.src.main;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Field> transitions = new ArrayList<>();
    public Board() {
        addLadders();
        addSnakes();
    }

    private void addLadders() {
        addTransition(new Ladder(2, 38));
        addTransition(new Ladder(7, 14));
        addTransition(new Ladder(8, 31));
        addTransition(new Ladder(15, 26));
        addTransition(new Ladder(21, 42));
        addTransition(new Ladder(28, 84));
        addTransition(new Ladder(36, 44));
        addTransition(new Ladder(51, 67));
        addTransition(new Ladder(71, 91));
        addTransition(new Ladder(78, 98));
        addTransition(new Ladder(87, 94));
    }

    private void addSnakes() {
        addTransition(new Snake(16, 6));
        addTransition(new Snake(49, 11));
        addTransition(new Snake(46, 25));
        addTransition(new Snake(62, 19));
        addTransition(new Snake(64, 60));
        addTransition(new Snake(74, 53));
        addTransition(new Snake(89, 68));
        addTransition(new Snake(92, 88));
        addTransition(new Snake(95, 75));
        addTransition(new Snake(99, 80));
    }

    public void addTransition(Field t) {
        transitions.add(t);
    }

    public int applyMove(int position) {
        for (Field t : transitions) {
            if (t.getStart() == position) {
                return t.getEnd();
            }
        }
        return position;
    }
}
