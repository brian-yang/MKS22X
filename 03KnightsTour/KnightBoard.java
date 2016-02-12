public class KnightBoard implements hw03 {
    private int[][] board;

    public KnightBoard(int size) {
	board = new int[size][size];
	populate();
    }

    private void populate() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board.length; j++) {
		board[i][j] = 0;
	    }
	}
    }

    public boolean solve() { return solveH(); }
    private boolean solveH() {} // recursion
    public void printSolution() {}

    private int[] findMoves(int row, int column) {
	String[] moves = new String[8]; // max 8 moves
	for (int i = 0; i < moves.length; i++) {
	    moves[i] = "-100,-100";
	}
	// -|
	//  |
	//  |
	if (validSpot(row - 2, column - 1)) {
	    moves[0] = Integer.toString(row - 2) + "," +
		Integer.toString(column - 1);
	}
	//  |-
	//  |
	//  |
	if (validSpot(row - 2, column + 1)) {
	    moves[1] = Integer.toString(row - 2) + "," +
		Integer.toString(column + 1);
	}
	//  |
	//  |
	// -|
	if (validSpot(row + 2, column - 1)) {
	    moves[2] = Integer.toString(row + 2) + "," +
		Integer.toString(column - 1);
	}
	//  |
	//  |
	//  |-
	if (validSpot(row + 2, column + 1)) {
	    moves[3] = Integer.toString(row + 2) + "," +
		Integer.toString(column + 1);
	}
	//  _ _ _ |
	if (validSpot(row - 1, column + 2)) {
	    moves[4] = Integer.toString(row - 1) + "," +
		Integer.toString(column + 2);
	}
	//  _ _ _ 
	//        |
	if (validSpot(row + 1, column + 2)) {
	    moves[5] = Integer.toString(row + 1) + "," +
		Integer.toString(column + 2);
	}
	// | _ _ _
	if (validSpot(row - 1, column - 2)) {
	    moves[6] = Integer.toString(row - 1) + "," +
		Integer.toString(column - 2);
	}
	//  _ _ _
	// |
	if (validSpot(row + 1, column - 2)) {
	    moves[7] = Integer.toString(row + 1) + "," +
		Integer.toString(column - 2);
	}
    }

}
