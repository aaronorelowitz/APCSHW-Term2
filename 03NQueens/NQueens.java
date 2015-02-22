import java.util.*;
import java.io.*;


public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    private String[][]board;

    
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


    public String name(){
	return "orelowitz.aaron";
    }
    
    public String toString(){
	String ans = ""+ solve() + "\n";
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board[x].length; y++){
		ans = ans + board[x][y];}
	    ans = ans + "\n";}
	return ans;
    }
    
    public NQueens(int size){
	board = new String[size][size];
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board[x].length; y++){
		board[x][y] = "-";}}
    }
    
    
    
    public boolean solve(){
	return solve(0, 0, 1);
    }
    
    
    public boolean solve(int x){
	return solve(x, 0, 1);
    }
    
    
    
    
    public boolean solve(int x,int y,int currentMoveNumber){
	if(x < 0 || x >= board.length || y < 0 || y >= board.length){
	    return false;}
	if(board[x][y] != "-"){
	    return false;}
	for (int i = 0; i < board.length; i++){
	    if(board[x][i] != "-"){
	        return false;}
	    if(board[i][y] != "-"){
		return false;}
	    if(y - i >= 0 && x + i < board.length){
		if (board[x + i][y - i] != "-"){
		    return false;}}
	    if(y - i >= 0 && x - i >= 0){
		if (board[x - i][y - i] != "-"){
		    return false;}}}
	board[x][y] = "Q";
	if(currentMoveNumber == board.length){
	    return true;}
	for (int i = 0; i < board.length; i++){
	    if (solve(i, y + 1, currentMoveNumber + 1)){
		return true;}}
	board[x][y] = "-";
	return false;
	}
    

    public static void main(String[]args){
	NQueens x = new NQueens(8);
	System.out.println(x);			
    }
    
}




