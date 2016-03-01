import java.io.*;
import java.util.*;

public class Silver {
    public static void main(String[] args) {
	Scanner in;
	char[][] maze;
	int rows;
	int cols;
	int numMoves;
	try {
	    in = new Scanner(new File("ctravel.in"));
	    // take first line
	    Scanner firstLine = new Scanner(in.nextLine());
	    rows = firstLine.nextInt();
	    cols = firstLine.nextInt();
	    maze = new char[rows][cols];
	    numMoves = firstLine.nextInt();

	    // create maze
	    maze = initializeMaze(in, maze, "");
	    //System.out.println(Arrays.deepToString(maze));

	    // get start and end coords
	    int[] startCoords = {in.nextInt(), in.nextInt()};
	    int[] endCoords = {in.nextInt(), in.nextInt()};
	} catch (FileNotFoundException e) {
	    System.out.println("Could not find file!");
	    System.out.println(e.getMessage());
	    System.exit(0);
	}
    }

    private static char[][] initializeMaze(Scanner in, char[][] maze, String line) {	    
	for (int i = 0; i < maze.length; i++) {
	    line = in.nextLine().trim();
	    for (int j = 0; j < maze[0].length; j++) {
		maze[i][j] = line.charAt(j); // get next char
	    }
	}
	return maze;
    }
    
}
