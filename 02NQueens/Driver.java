public class Driver {
    public static void main(String[] args) {
	QueenBoard board = new QueenBoard(3);
	board.solve();
	System.out.println(board);
    }
}
