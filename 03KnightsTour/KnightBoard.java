public class KnightBoard implements hw03 {
    private int[][] board;
    private int[] rowInc;
    private int[] colInc;

    public KnightBoard(int col, int rows) {
	newBoard(col, rows);
	possibleRowShifts(); // When a knight moves, its row position may change
	possibleColumnShifts(); // When a knight moves, its column position may change
    }

    public KnightBoard(int size) {
	this(size, size);
    }

    private void possibleRowShifts() {
	rowInc = new int[] {2, 2, -2, -2,
			    1, 1, -1, -1};
    }

    private void possibleColumnShifts() {
	colInc = new int[] {1, -1, 1, -1, 
			    2, -2, 2, -2};
    }

    private void newBoard(int col, int rows) {
	board = new int[col][rows]; // KnightBoard
	for (int i = 0; i < col; i++) {
	    for (int j = 0; j < rows; j++) {
		board[i][j] = 0;
	    }
	}
    }
    //========================================================
    public boolean solve() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (solveH(i, j, 1)) {
		    return true;
		}
	    }
	}
	return false;
    }
    private boolean solveH(int row, int column, int counter) {
	if (!validSpot(row, column)) {
	    return false;
	}
	board[row][column] = counter; 
	if (counter == board.length * board[0].length) {
	    return true;
	}
	for (int i = 0; i < 8; i++) {
	    if (solveH(row + rowInc[i], column + colInc[i], counter + 1)) {
		return true;
	    }
	}
	board[row][column] = 0;
	return false;
    }
    public void printSolution() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		System.out.print(board[i][j] + " ");
	    }
	    System.out.println();
	}
    }
    //========================================================
    private boolean validSpot(int row, int column) {
	if (row >= board.length || row < 0 ||
	    column >= board[0].length || column < 0) {
	    return false;
	}
	return board[row][column] == 0;
    }

}
