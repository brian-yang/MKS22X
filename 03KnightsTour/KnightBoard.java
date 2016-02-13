import java.util.Arrays;

public class KnightBoard implements hw03 {
    private int[][] board;
    private int[] tmpCoordData;
    private int numMoves;

    public static void main(String[] args) {
	KnightBoard knightboard = new KnightBoard(6);
	knightboard.solve();
	knightboard.printSolution();
    }

    public KnightBoard(int size) {
	board = new int[size][size]; // KnightBoard
	populate();
        tmpCoordData = new int[] {0, 0};
        numMoves = 0;
    }

    private void populate() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board.length; j++) {
		board[i][j] = 0;
	    }
	}
    }
    //========================================================
    public boolean solve() {
	int startRow = (int) (Math.random() * board.length);
	int startColumn = (int) (Math.random() * board.length);
	return solveH(startRow, startColumn, 1); 
    }
    private boolean solveH(int row, int column, int counter) {
	if (counter == board.length * board.length) {
	    board[row][column] = counter;
	    return true;
	}
	String[] knightMoves = findMoves(row, column);
	if (Integer.parseInt(knightMoves[8]) != 0) {
	    board[row][column] = counter;
	    for (int i = 0; i < 8; i++) {
		if (!knightMoves[i].isEmpty()) {
		    tmpCoordData[0] = Integer.parseInt(knightMoves[i].split(",")[0]);
		    tmpCoordData[1] = Integer.parseInt(knightMoves[i].split(",")[1]);						    
		    if (solveH(tmpCoordData[0], tmpCoordData[1], counter + 1)) {
			return true;
		    }
		}
	    }
	    board[row][column] = 0; // reset spot since no solutions were found and true was not returned
	}
	return false;
    }
    public void printSolution() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board.length; j++) {
		System.out.print(board[i][j] + " ");
	    }
	    System.out.println();
	}
    }
    //========================================================
    private boolean validSpot(int row, int column) {
	if (row >= board.length || row < 0 ||
	    column >= board.length || column < 0) {
	    return false;
	}
	if (board[row][column] != 0) {
	    return false;
	}
	return true;
    }

    private String[] findMoves(int row, int column) {
	int possible = 0;
	String[] moves = new String[9]; // last index used to store num of possible moves
	// -|
	//  |
	//  |
	if (validSpot(row - 2, column - 1)) {
	    moves[0] = Integer.toString(row - 2) + "," +
		Integer.toString(column - 1);
	    possible++;
	} else {
	    moves[0] = "";
	}
	//  |-
	//  |
	//  |
	if (validSpot(row - 2, column + 1)) {
	    moves[1] = Integer.toString(row - 2) + "," +
		Integer.toString(column + 1);
	    possible++;
	} else {
	    moves[1] = "";
	}
	//  |
	//  |
	// -|
	if (validSpot(row + 2, column - 1)) {
	    moves[2] = Integer.toString(row + 2) + "," +
		Integer.toString(column - 1);
	    possible++;
	} else {
	    moves[2] = "";
	}
	//  |
	//  |
	//  |-
	if (validSpot(row + 2, column + 1)) {
	    moves[3] = Integer.toString(row + 2) + "," +
		Integer.toString(column + 1);
	    possible++;
	} else {
	    moves[3] = "";
	}
	//  _ _ _ |
	if (validSpot(row - 1, column + 2)) {
	    moves[4] = Integer.toString(row - 1) + "," +
		Integer.toString(column + 2);
	    possible++;
	} else {
	    moves[4] = "";
	}
	//  _ _ _ 
	//        |
	if (validSpot(row + 1, column + 2)) {
	    moves[5] = Integer.toString(row + 1) + "," +
		Integer.toString(column + 2);
	    possible++;
	} else {
	    moves[5] = "";
	}
	// | _ _ _
	if (validSpot(row - 1, column - 2)) {
	    moves[6] = Integer.toString(row - 1) + "," +
		Integer.toString(column - 2);
	    possible++;
	} else {
	    moves[6] = "";
	}
	//  _ _ _
	// |
	if (validSpot(row + 1, column - 2)) {
	    moves[7] = Integer.toString(row + 1) + "," +
		Integer.toString(column - 2);
	    possible++;
	} else {
	    moves[7] = "";
	}
	moves[8] = Integer.toString(possible);
	return moves;
    }

}
