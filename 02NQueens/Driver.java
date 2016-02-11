public class Driver {
    public static void main(String[] args) {
	QueenBoard board;
	if (args.length == 0) {
	    board = new QueenBoard(5);
	} else {
	    board = new QueenBoard(Integer.parseInt(args[0]));
	}
	System.out.println(board.solve());
	board.printSolution();
    }
}
