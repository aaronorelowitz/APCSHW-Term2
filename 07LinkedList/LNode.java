import java.util.*;

public class LNode{
    private int value;
    private LNode next;

    public LNode(int val, LNode nex){
	value = val;
	next = nex;
    }

    public LNode(int val){
	value = val;
	next = null;
    }

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
