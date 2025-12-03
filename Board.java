import java.util.HashMap;
import java.util.Map;

public class Board {

    private final Map<Integer, Integer> transitions = new HashMap<>();

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

    private void addTransition(BoardTransition transition) {
        transitions.put(transition.getStart(), transition.getEnd());
    }

    public int applyMove(int position) {
        return transitions.getOrDefault(position, position);
    }
}
