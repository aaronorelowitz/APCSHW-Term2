import java.util.*;

public class MyLinkedList{

    public LNode head;

    public String toString(){
	String ans = "[ ";
	LNode x = head; 
	while(x.getNext() != null){
	    ans = ans + x.getValue() + ", ";
	    x = x.getNext();}
	return ans;
    }

    


}
