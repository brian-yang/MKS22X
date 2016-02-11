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

    private int[] findMoves(int row, int column) {
	int[] moves = new int[8]; // max 8 moves
	// -|
	//  |
	//  |
	if (validSpot(row + 2, column - 1)) {
	    moves[0] = Integer.toString(row + 2) + "," +
		Integer.toString(column - 1);
	}
	//  |-
	//  |
	//  |
	if (validSpot(row + 2, column + 1)) {
	    moves[1] = Integer.toString(row + 2) + "," +
		Integer.toString(column + 1);
	}

}
