import java.util.*;

public class LNode{
    private int value;
    private LNode next;

    public LNode getNext(){
	return next;}

    public int getValue(){
	return value;}

    public void setNext(LNode newNext){
	next = newNext;}

    public void setValue(int newValue){
	value = newValue;
    }

    public String toString(){
	return "" +  value;}


}
