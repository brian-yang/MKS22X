import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Silver {
    public static void main(String[] args) {
	try {
	    Scanner in = new Scanner(new File("ctravel.in"));
	    Scanner firstLine = new Scanner(in.nextLine());
	    int[][] maze = new int[firstLine.nextInt()][firstLine.nextInt()];
	    int numMoves = firstLine.nextInt();
	    boolean debug;

	    // create maze
	    maze = initializeMaze(in, maze, "");

	    // debug
	    if (args.length > 0 && args[0].equals("--debug")) {
		debug = true;
	    } else {
		debug = false;
	    }
	    // debug: check if file has been read and parsed
	    if (debug) {
		System.out.println(Arrays.deepToString(maze));		
	    }

	    // get start and end coords
	    int[] startCoords = {in.nextInt(), in.nextInt()};
	    int[] endCoords = {in.nextInt(), in.nextInt()};

	    System.out.println(solve(maze, startCoords, endCoords,
	    			     0, numMoves, debug));

	} catch (FileNotFoundException e) {
	    System.out.println("Could not find file!");
	    System.out.println(e.getMessage());
	    System.exit(0);
	}
    }

    private static int[][] initializeMaze(Scanner in, int[][] maze, String line) {	    
	for (int i = 0; i < maze.length; i++) {
	    line = in.nextLine();
	    for (int j = 0; j < maze[0].length; j++) {
		if (line.charAt(j) == '*') {
		    maze[i][j] = -1;		   
		} else {
		    maze[i][j] = 0;
		}
	    }
	}
	return maze;
    }

    private static int solve(int[][] maze, int[] start, int[] end, int curMove, int totalMoves, boolean debug) {
	if (curMove == 0) {
	    maze[start[0] - 1][start[1] - 1] = 1;
	    return solve(maze, start, end, 1, totalMoves, debug);
	} else if (curMove == totalMoves + 1) {
	    return maze[end[0] - 1][end[1] - 1];
	} else {
	    // debug: check values of spots in the maze currently
	    if (debug) {
		printMaze(maze);
		System.out.println();		
	    }

	    maze = updateMaze(maze);

	    return solve(maze, start, end, curMove + 1, totalMoves, debug);
	}
    }

    private static void printMaze(int[][] maze) {
	for (int i = 0; i < maze.length; i++) {
	    for (int j = 0; j < maze[0].length; j++) {
		System.out.print(maze[i][j] + " ");
	    }
	    System.out.println();
	}
    }

    private static int[][] updateMaze(int[][] maze) {
	int maze2[][] = new int[maze.length][maze[0].length];
	for (int i = 0; i < maze2.length; i++) {
	    for (int j = 0; j < maze2[0].length; j++) {
		if (maze[i][j] != -1) {
		    maze2[i][j] = getSumNeighbors(maze, i, j);
		} else {
		    maze2[i][j] = -1;
		}
	    }
	}
	return maze2;
    }

    private static int getSumNeighbors(int[][] maze, int row, int col) {
	int sum = 0;
	if (validSpot(maze, row + 1, col)) {
	    sum += maze[row + 1][col];
	}
	if (validSpot(maze, row, col + 1)) {
	    sum += maze[row][col + 1];
	}
	if (validSpot(maze, row - 1, col)) {
	    sum += maze[row - 1][col];
	}
	if (validSpot(maze, row, col - 1)) {
	    sum += maze[row][col - 1];
	}
	return sum;
    }
	
    private static boolean validSpot(int[][] maze, int row, int col) {
	if (row < 0 || row >= maze.length ||
	    col < 0 || col >= maze[0].length) {
	    return false;
	}
	if (maze[row][col] == -1) {
	    return false;
	}
	return true;
    }

}
