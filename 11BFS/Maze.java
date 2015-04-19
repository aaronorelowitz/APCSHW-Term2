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
        return toString(false);
    }
    public String toString(boolean animate) {
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	if (animate)
	    return hide+invert+go(0,0)+ans+"\n"+show;
	return ans;
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

   

    public boolean solveBFS(){
	return solveBFS(false);
    }
  
    public boolean solveDFS(boolean animate){
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}
	boolean solved = false;
	int[] next = new int[2];
	while (!solved && frontier.size() > 0){
	    if (animate && !solved){
		System.out.println(clear + toString(true));
		System.out.println(frontierToString());
		wait(50);
	    }
	    maze[next[1]][next[0]] = '.';
	    maze[starty][startx] = 'S';
	    maze[0][0] = '#';
	    if (mode == DFS){
	        next = frontier.removeLast();
	    }
	    //check if its solved
	    if (maze[next[1]][next[0]] == 'E'){
		solved = true;
		return solved;
		 moves.add(next);
	    }else{ //if its not solved
		maze[next[1]][next[0]] = '.';
		for (int[] a : getNeighbors(next[0],next[1])){
		    frontier.addLast(a);
		}
	    }
	}
	if (!solved){
	    System.out.println("Sorry, we could not find a solution!");
	}
	
	return solved;
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
