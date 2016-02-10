import java.util.Arrays;

public class Board implements hw02 {
    private int[][] board;
    private int size;

    public String name() {
	return "Yang,Brian";
    }
    
    public Board(int size) {
	this.size = size;
        board = new int[size][size];
	populate();
    }

    private void populate() {
	for (int i = 0; i < size; i++) {
	    for (int j = 0; j < size; j++) {
		board[i][j] = 0;
	    }
	}
    }

    // Utilizes state space search
    public boolean solve() { return true; } // to be fixed
    public String toString() {
	return Arrays.deepToString(board);
    }

    // Add a queen to a column
    // Where the queen is placed matters
    // to make sure no placements are repeated
    public boolean addQueen(int row, int column) {
	if (board[row][column] == 0) {
	    board[row][column] = 1;
	    changeStateOfBoardSquare(row, column, -1);
	    return true;
	}
	return false;
    }

    // Check if queen is somewhere within the column
    // Don't care where the queen is placed; it will still be
    // removed
    public boolean removeQueen(int column) {
	int row;
	for (int row = 0; row < size; row++) {
	    if (board[row][column] == 1) {
		board[row][column] = 0;
		changeStateOfBoardSquare(row, column, 1);
		return true;
	    }
	}
	return false;
    }

    private void changeStateOfBoardSquare(int row, int column, int amt) {
	// horizontal
	for (int i = column + 1; i < size; i++) {
	    board[row][column] += amt;
	}

	// upper diagonal
	for (int i = row + 1; i < size; i++) {
	    for (int j = column + 1; j < size; j++) {
		board[row][column] += amt;
	    }
	}

	// lower diagonal
	for (int i = row - 1; i < size; i--) {
	    for (int j = column - 1; j < size; j--) {
		board[row][column] += amt;
	    }
	}
    }

}
