import java.util.Scanner;
import java.io.*;

public class Bronze {
    public static void main(String[] args) throws IOException {
	Scanner in = new Scanner(new File("makelake.in"));
	int[][] pasture = new int[in.nextInt()][in.nextInt()];
	int finalElevation = in.nextInt();
	int numStompCommands = in.nextInt();
	int[][] stompCommands = new int[numStompCommands][3]; 
	
	for (int i = 0; i < pasture.length; i++) {
	    for (int j = 0; j < pasture[0].length; j++) {
		pasture[i][j] = in.nextInt();
	    }
	}

	for (int i = 0; i < numStompCommands; i++) {
	    for (int j = 0; j < 3; j++) {
		stompCommands[i][j] = in.nextInt();
	    }
	    pasture = stomp(stompCommands[i], pasture);
	}

	int totalPastureDepth = 0;
	
	for (int i = 0; i < pasture.length; i++) {
	    for (int j = 0; j < pasture[0].length; j++) {
		if (pasture[i][j] < finalElevation) {
		    totalPastureDepth += finalElevation - pasture[i][j];
		}
	    }
	}
	//System.out.println(totalPastureDepth);
	System.out.println(calculateVolume(totalPastureDepth));
    }

    private static int calculateVolume(int totalPastureDepth) {
	return totalPastureDepth * 72 * 72;
    }
    private static int[][] stomp(int[] commands, int[][] pasture) {
	int startRow = commands[0];
	int startCol = commands[1];
	int numStomps = commands[2];
	int[] maxValueCoords = getMax(startRow, startCol, pasture);
	int result = pasture[maxValueCoords[0]][maxValueCoords[1]] - numStomps;
	for (int i = startRow - 1; i < startRow + 2; i++) {
	    for (int j = startCol - 1; j < startCol + 2; j++) {
		if (result < pasture[i][j]) {
		    pasture[i][j] = result;
		}
	    }
	}
	return pasture;
    }

    private static int[] getMax(int startRow, int startCol, int[][] pasture) {
	//System.out.println(startRow);
	//System.out.println(startCol);
	int max = 0; // max value in 3 x 3 grid
	int[] maxValueCoords = new int[2];
	for (int i = startRow - 1; i < startRow + 2; i++) {
	    for (int j = startCol - 1; j < startCol + 2; j++) {
		if (pasture[i][j] > max) {
		    max = pasture[i][j];
		    maxValueCoords[0] = i;
		    maxValueCoords[1] = j;
		}
	    }
	}
	return maxValueCoords;
    }
}
