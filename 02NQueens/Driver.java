public class Driver {
    public static void main(String[] args) {
	Board board = new Board(3);
	System.out.println(board);
	board.addQueen(0, 0);
	board.addQueen(1, 1);
    }
}
