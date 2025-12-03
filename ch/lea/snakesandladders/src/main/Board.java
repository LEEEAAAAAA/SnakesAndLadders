package ch.lea.snakesandladders.src.main;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Field> transitions = new ArrayList<>();

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
