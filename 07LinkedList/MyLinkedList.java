import java.util.*;

public class MyLinkedList{

    public LNode head;
    
    public MyLinkedList(){
	head = null;}

    public String toString(){
	String ans = "[ ";
	LNode x = head; 
	while(x != null){
	    ans = ans + x.getValue() + ", ";
	    x = x.getNext();}
	return ans.substring(0, ans.length() - 2) + "]";
    }

    public boolean add(int e){
	LNode node = new LNode(e);
	if(head == null){
	    head = node;}
	else{LNode x = head; 
	while(x != null && x.getNext() != null){
	    x = x.getNext();}

	x.setNext(node);}
	return true;}
    

    public static void main(String[]args){
	MyLinkedList test = new MyLinkedList();
	System.out.println(test);
	test.add(7);
	System.out.println(test);
    }

}
