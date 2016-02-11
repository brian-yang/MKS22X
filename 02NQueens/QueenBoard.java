public class QueenBoard implements hw02 {
    private int[][] board;
    private int numQueens;

    public QueenBoard(int size) {
	board = new int[size][size];
	numQueens = 0;
    }

    public String name() {
	return "Yang,Brian";
    }

    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve()
    {
	return solveH(0);
    }

    /**
     *Helper method fr solve. 
     */
    private boolean solveH(int col){
	for (int i = 0; i < board.length; i++) {
	    if (addQueen(i, col)) {
		if (col == board.length - 1) {
		    return true;
		}
		if (solveH(col + 1)) {
		    return true;
		} else {
		    removeQueen(i, col);
		}
	    }
	}
	return false;
		
    }

    public void printSolution(){
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board.length; j++) {
		if (board[i][j] == 1) {
		    System.out.print(" Q ");
		} else {
		    System.out.print(" _ ");
		}
	    }
	    System.out.print('\n');
	}
    }

    /********Do Not Edit Below This Line**********************************/

    private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	numQueens++;
	return true;
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	numQueens--;
	return true;
    }

    public String toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }

    /*
    public static void main(String[]args){
        Board b = new Board(5);
	b.solve();
        System.out.println(b);
    }
    */
}
