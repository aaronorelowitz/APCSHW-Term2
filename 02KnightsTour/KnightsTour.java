import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    private int[][]board;

    
    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public String toString(){
	String ans = "\n";
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board[x].length; y++){
		ans = ans + board[x][y];}
	    ans = ans + "\n";}
	return ans;
    }
    
    public KnightsTour(int size){
	board = new int[size][size];
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board[x].length; y++){
		board[x][y] = 0;}}
    }
    
    
    
    public boolean solve(){
	return solve(0, 0, 1);
    }
    
    
    public boolean solve(int startx, int starty){
	return solve(startx, starty, 1);
    }
    
    
    
    
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);
	if(x < 0 || x >= board.length || y < 0 || y >= board.length){
	    return false;}
	if(board[x][y] != 0){
	    return false;}
	board[x][y] = currentMoveNumber;
	if(currentMoveNumber == board.length * board.length){
	    return true;}
	if(solve(x + 1,y + 2,currentMoveNumber + 1) ||
	   solve(x + 1,y - 2,currentMoveNumber + 1) ||
	   solve(x - 1,y + 2,currentMoveNumber + 1) ||
	   solve(x - 1,y - 2,currentMoveNumber + 1) ||
	   solve(x + 2,y + 1,currentMoveNumber + 1) ||
	   solve(x + 2,y - 1,currentMoveNumber + 1) ||
	   solve(x - 2,y + 1,currentMoveNumber + 1) ||
	   solve(x - 2,y - 1,currentMoveNumber + 1)){
	    return true;}
	return false;
	}
    

    public static void main(String[]args){
	KnightsTour x = new KnightsTour(6);
	System.out.println(x);
	System.out.println(x.solve());
	System.out.println(x);
				
    }
    
}
