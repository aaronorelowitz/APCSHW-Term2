import java.io.*;

public class makelake {
    static int rows, cols, elevation, N;
    static int[][] pasture, directions;

    public static void main(String[] args) throws Exception {
	try {
	    BufferedReader in = new BufferedReader(
		    new FileReader("makelake.in"));

	    String[] vars = in.readLine().split(" ");
	    rows = Integer.parseInt(vars[0]);
	    cols = Integer.parseInt(vars[1]);
	    elevation = Integer.parseInt(vars[2]);
	    N = Integer.parseInt(vars[3]);

	    pasture = new int[rows][cols];
	    directions = new int[N][3];

	    String[] line;
	    for (int i = 0; i < rows; i++) {
		line = in.readLine().split(" ");
		for (int j = 0; j < cols; j++) {
		    pasture[i][j] = Integer.parseInt(line[j]);
		}
	    }

	    //printPasture();

	    for (int i = 0; i < N; i++) {
		line = in.readLine().split(" ");
		for (int j = 0; j < 3; j++) {
		    directions[i][j] = Integer.parseInt(line[j]);
		}
	    }

	} catch (Exception e) {
	    throw e;
	}

	makeLake();
	//printPasture();
	System.out.println(getVolume());
    }

    static void printPasture() {
	String out = "";
	for (int[] row : pasture) {
	    for (int col : row) {
		out += col + " ";
	    }
	    out += "\n";
	}
	System.out.println(out);
    }

    static void makeLake() {
	int row, col, depth;
	for (int i = 0; i < directions.length; i++) {
	    row = directions[i][0] - 1;
	    col = directions[i][1] - 1;
	    depth = directions[i][2];

	    int max = 0;
	    for (int j = 0; j < 3; j++) {
		for (int k = 0; k < 3; k++) {
		    if (pasture[row + j][col + k] > max)
			max = pasture[row + j][col + k];
		}
	    }

	    max -= depth;

	    for (int j = 0; j < 3; j++) {
		for (int k = 0; k < 3; k++) {
		    if (pasture[row + j][col + k] > max)
			pasture[row + j][col + k] = max;
		}
	    }
	}
    }
    
    static int getVolume() {
	int depth = 0;
	int addedDepth = 0;
	for (int[] row : pasture) {
	    for (int col : row) {
		addedDepth = elevation - col;
		if (addedDepth > 0)
		    depth += addedDepth;
	    }
	}
	return depth * 72 * 72;
    }
}
