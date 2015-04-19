import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    
    MyDeque frontier;

    private String go(int x,int y){
    return ("\033[" + x + ";" + y + "H");
    }

    public Maze(String filename){
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    maxx = line.length();
		}
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
		startx = i % maxx;
		starty = i / maxx;
	    }
	}
    }

    public String toString(){
	String ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
	for(int i = 0; i < maxx * maxy; i++){
	    if(i % maxx == 0 && i != 0){
		ans += "\n";
	    }
	    char c =  maze[i % maxx][i / maxx];
	    if(c == '#'){
		ans += c;
	    }else{
		ans += c;
	    }
	}
	return hide + go(0,0) + ans + "\n" + show;
    }
    
    
    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveBFS(boolean animate){   
	if (animate == true){ 
	    wait(10);
	    clearTerminal();
	    System.out.println(this);
	}
	return false;
	
    }

    public boolean solve(boolean animate, int mode){
	if(startx < 0){
	    System.out.println("No starting point");
	    return false;
	}
	int[] z = {startx, starty};
	frontier.add(z);
	boolean solved = false;
	int[] next = new int[2];
	while (!solved && frontier.size() > 0){
	    if (animate && !solved){
		System.out.println(toString(true));
		System.out.println(frontierToString());
		wait(50);
	    }
	    if (mode == BFS){
		maze[next[1]][next[0]] = '.';
	        next = frontier.removeFirst();
	    }
	    if (mode == DFS){
		maze[next[1]][next[0]] = '.';
	        next = frontier.removeLast();
	    }
	    if (maze[next[1]][next[0]] == 'E'){
		solved = true;
		break;
	    }else{ 
		maze[next[1]][next[0]] = 'X';
		for (int[] a : getNeighbors(next[0],next[1])){
		    frontier.addLast(a);
		}
	    }
	}
	return solved;
    }

   

    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }
    

    public void clearTerminal(){
	System.out.println(clear);}
    
       /**return an array [x1,y1,x2,y2,x3,y3...]
      *that contains the coordinates of the solution from start to end.
      *Precondition :  solveBFS() OR solveDFS() has already been called (otherwise an empty array is returned)
      *Postcondition:  the correct solution is in the returned array
       */
    //public int[] solutionCoordinates(){ }    


}
