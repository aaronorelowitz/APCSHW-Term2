import java.io.*;
import java.util.*;


public class ctravel {
    
    public static int solve(String[][]board,int x0, int y0, int x1, int y1, int steps){
	if(steps == 0){
	    if(x0 == x1 && y0 == y1){
		return 1;
	    }else{return 0;}}
	String here = " ";
	try{
	    here = board[x0][y0];
	}catch(ArrayIndexOutOfBoundsException e){
	    return 0;}
	if (here.equals("*")){
	    return 0;}
	return solve(board, x0 - 1, y0, x1, y1, steps-1) +
	    solve(board, x0, y0 + 1, x1, y1, steps-1) +
	    solve(board, x0 + 1, y0, x1, y1, steps-1) +
	    solve(board, x0, y0 - 1, x1, y1, steps-1);
	    
    }



    private static String readFile( String file ) throws IOException {
	BufferedReader reader = new BufferedReader( new FileReader (file));
	String         line = null;
	StringBuilder  stringBuilder = new StringBuilder();
	String         ls = System.getProperty("line.separator");
	
	while( ( line = reader.readLine() ) != null ) {
	    stringBuilder.append( line );
	    stringBuilder.append( ls );
	}

	return stringBuilder.toString();
    }

    public static void main(String[]args){
	int rows;
	int cols;
	int steps = 0;
	String [][] pasture;
	int x0;
	int y0;
	int x1;
	int y1;
	String[]lines;
	try {
	    lines = readFile("ctravel.in.txt").split("\n");
	}catch(IOException e){
	    System.out.println("didn't work");
	    lines = new String[2];}
	String[] line0 = lines[0].split( " " );
        rows = Integer.parseInt( line0[0] );
	cols = Integer.parseInt( line0[1] );
	cols = Integer.parseInt( line0[1] );
	String x = line0[2];
	steps = Integer.parseInt( x );
	pasture = new String[rows][cols];
	for (int r=1; r <= rows; r++) {
	    String[] line = lines[r].split(" ");	    
	    for (int c=0; c < cols; c++) {
		if ( lines[r].substring(c, c+1).equals("*") ) {
		    pasture[r-1][c] = "*";
		}
	    }
	}
	line0 = lines[rows+1].split(" ");
        x0 = Integer.parseInt( line0[0] );
	y0 = Integer.parseInt( line0[1] );
	x1 = Integer.parseInt( line0[2] );
	y1 = Integer.parseInt( line0[3] );

	solve(pasture, x0, y0, x1, y1, steps);
    }
}
 
