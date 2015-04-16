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










































































import java.util.*;
import java.io.*;

public class Mazesolver{
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private String clear =  "\033[2J";
    private String hide =  "\033[?25l";
    private String show =  "\033[?25h";
    
    public Mazesolver(String filename){
	startx = -1;
	starty = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    
	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    //calculate width of the maze
		    maxx = line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	
	//copy from the single string to a 2D array
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
    
    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }
    
    public void clearTerminal(){
				System.out.println(clear);
    }
    
    public void wait(int millis){
				try {
				    Thread.sleep(millis);
				}
				catch (InterruptedException e) {
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
		ans += color(38,47)+c;
						}else{
		ans += color(32,40)+c;
	    }
	}
	return hide + go(0,0) + ans + "\n" + show + color(37,40);
    }
    
    public boolean solve(){
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    maze[startx][starty] = ' ';
	    return solve(startx,starty);
	}
    }
    
    public boolean solve(int x,int y){
	System.out.println(this);
	wait(20);
	if(maze[x][y] == 'E'){
	    return true;
	}
	if(maze[x][y] == ' '){
						//mark the floor with @
	    maze[x][y] = '@';
	    //recursion ho!!
	    if( solve(x + 1, y) || solve( x, y + 1) ||
		solve(x - 1, y) ||	solve(x, y - 1)){
		return true;
	    }
	    //replace the @ with a .
	    maze[x][y] = '.';
				}
	return false;//by default the maze didn't get solved
    }
    
    
}
