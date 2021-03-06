import java.util.*;
import java.io.*;

public class Maze {

    private char[][] maze;
    private int startx, starty;
    private boolean animate, hasStart;

    /*Constructor loads a maze text file.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (only 1 per file)
      'S' - the location of the start(only 1 per file)
      
      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found, print an error and exit the program.
    */
    public Maze(String filename, boolean ani) {
	animate = ani;
	hasStart = false;
	try {
	    Scanner in = new Scanner(new File(filename));	    
	    String lines = "";
	    int numRows = 0;
	    int numCols = 0;
	    while (in.hasNextLine()) {
		lines += in.nextLine().trim();
		numRows++;
		if (numRows == 1) {
		    numCols = lines.length();
		}
	    }
	    initializeMaze(numRows, numCols, lines);

	} catch (FileNotFoundException e) {
	    System.out.println("Could not find file!");
	    System.out.println(e.getMessage());
	    System.exit(0);
	}
    }

    // Code to test if constructor is getting proper input
    // public static void main(String[] args) {
    // 	Maze m = new Maze("data1.dat", false);
    // 	//m.clearTerminal();
    // 	for (int i = 0; i < m.maze.length; i++) {
    // 	    for (int j = 0; j < m.maze[0].length; j++) {
    // 		System.out.print(m.maze[i][j]);
    // 	    }
    // 	    System.out.println();
    // 	}
    // }

    private void initializeMaze(int rows, int cols, String lines) {
	int numChars = 0;
	maze = new char[rows][cols];
	for (int i = 0; i < rows; i++) {
	    for (int j= 0; j < cols; j++) {
		maze[i][j] = lines.charAt(numChars);
		if (maze[i][j] == 'S') {
		    startx = i;
		    starty = j;
		    hasStart = true;
		}
		numChars++;
	    }
	}
    }

    /*Main Solve Function

      Things to note:
      When no S is contained in maze, print an error and return false.
    */
    public boolean solve() {
        if (!hasStart){
            System.out.println("No starting point 'S' found in maze.");
            return false;
        } else{
            return solve(startx,starty);
        }
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.
      The S is replaced with '@' but the 'E' is not.

      Postcondition:
      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      All visited spots that were not part of the solution are changed to '.'
      All visited spots that are part of the solution are changed to '@'

    */
    private boolean solve(int x, int y){
        if (animate){
            System.out.println(this);
            wait(20);
        }

	if (maze[x][y] == '#' || maze[x][y] == '.') {
	    return false;
	} else if (maze[x][y] == ' ' || maze[x][y] == 'S') {
	    maze[x][y] = '@';
	    if (solve(x + 1, y) || solve(x, y + 1) ||
		solve(x, y - 1) || solve(x - 1, y)) {
		return true;
	    }
	    maze[x][y] = '.';
	} else if (maze[x][y] == 'E') {
	    return true;
	}

        //COMPLETE SOLVE
        return false; //so it compiles
    }

    //=================================================================
    public void clearTerminal(){
        System.out.println(CLEAR_SCREEN);
    }

    public String toString() {
        int maxx = maze[0].length;
        int maxy = maze.length;
        String ans = "";
        if(animate){
            ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
        }

        for(int i = 0; i < maxx * maxy; i++){
            if(i % maxx == 0 && i != 0){
                ans += "\n";
            }
            char c =  maze[i / maxx][i % maxx];
            if(c == '#'){
                ans += color(38,47) + c;
            }else{
                ans += color(33,40) + c;
            }
        }
        return HIDE_CURSOR + go(0,0) + ans + "\n" + SHOW_CURSOR + color(37,40);
    }

    //MORE FREE STUFF!!! *you can ignore all of this*
    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    //terminal specific character to move the cursor
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }

    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }

    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }
}
