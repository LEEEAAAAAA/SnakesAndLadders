public class Board {

    private final int[] board = new int[101];

    public Board() {
        addLadders();
        addSnakes();
    }

    private void addLadders() {
        board[2] = 38;
        board[7] = 14;
        board[8] = 31;
        board[15] = 26;
        board[21] = 42;
        board[28] = 84;
        board[36] = 44;
        board[51] = 67;
        board[71] = 91;
        board[78] = 98;
        board[87] = 94;
    }

    private void addSnakes() {
        board[16] = 6;
        board[49] = 11;
        board[46] = 25;
        board[62] = 19;
        board[64] = 60;
        board[74] = 53;
        board[89] = 68;
        board[92] = 88;
        board[95] = 75;
        board[99] = 80;
    }

    public int applyMove(int position) {
        if (board[position] != 0) {
            return board[position];
        }
        return position;
    }
}
