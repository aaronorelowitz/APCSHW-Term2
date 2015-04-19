import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private static final String invert =  "[37";
    
    MyDeque<int[]> frontier, moves; 

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
    
    public String frontierToString(){
	if (frontier.size() == 0) {
	    return "[ ]";
	}
	String out = "[ ";
	int h = frontier.getStart();
	int t = frontier.getEnd();
	if (h < t){
	    for (int i = h; i < t; i++){
		out += "[" + frontier.get(i)[0] +", " + frontier.get(i)[1] +"]";}
	}else{
	    for (int i = h; i < frontier.size(); i++){
		out += "[" + frontier.get(i)[0]+", " + frontier.get(i)[1] +"] , ";}
	    for (int i = 0; i <= t; i++){
		out += "[" + frontier.get(i)[0]+", " + frontier.get(i)[1] +"] , ";}
	}
	return hide+out+"]\n"+show;
    }
    
    public boolean solveBFS(boolean animate){
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
	    }
	    maze[next[1]][next[0]] = '.';
	    maze[starty][startx] = 'S';
	    maze[0][0] = '#';
	    next = frontier.removeFirst();
	    if (maze[next[1]][next[0]] == 'E'){
		solved = true;
		return solved;
	    }else{ 
		maze[next[1]][next[0]] = '.';
		for (int[] a : getNeighbors(next[0],next[1])){
		    frontier.addLast(a);
		}
	    }
	}
	return solved;
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
	    }
	    maze[next[1]][next[0]] = '.';
	    maze[starty][startx] = 'S';
	    maze[0][0] = '#';
	    next = frontier.removeLast();
	    if (maze[next[1]][next[0]] == 'E'){
		solved = true;
		return solved;
	    }else{
		maze[next[1]][next[0]] = '.';
		for (int[] a : getNeighbors(next[0],next[1])){
		    frontier.addLast(a);
		}
	    }
	}
	return solved;
    }

    
    public ArrayList<int[]> getNeighbors(int x, int y){
	ArrayList<int[]> neighbors = new ArrayList<int[]>();
	if (maze[y][x+1] == 'E'){
	    int[]ans = {x+1, y};
	    neighbors.add(ans);
	    return neighbors;	}
	if (maze[y][x-1] == 'E'){ 
	    int[]ans = {x-1, y};
	    neighbors.add(ans);
	    return neighbors;	}
	if (maze[y+1][x] == 'E'){ 
	    int[]ans = {x, y+1};
	    neighbors.add(ans);
	    return neighbors;	}
	if (maze[y-1][x] == 'E'){ 
	    int[]ans = {x, y-1};
	    neighbors.add(ans);
	    return neighbors;	}
	if (maze[y][x+1] == ' '){
	    maze[y][x+1] = 'X';
	    int[]ans = {x+1, y};
	    neighbors.add(ans);	}
	if (maze[y][x-1] == ' '){
	    maze[y][x-1] = 'X';
	    int[]ans = {x-1, y};
	    neighbors.add(ans);	} 
	if (maze[y+1][x] == ' '){
	    maze[y+1][x] = 'X';
	    int[]ans = {x, y+1};
	    neighbors.add(ans);	}
	if (maze[y-1][x] == ' '){
	    maze[y-1][x] = 'X';
	    int[]ans = {x, y-1};
	    neighbors.add(ans);	}
	return neighbors;
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
