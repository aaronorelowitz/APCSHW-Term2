import java.util.*;

public class MyLinkedList{

    public LNode head;
    public LNode tail;
    public int size;
    
    public MyLinkedList(){
	head = null;
	tail = null;
	size = 0;}

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
	else{tail.setNext(node);}
	size = size + 1;
	tail = node;
	return true;}
    

    public boolean add(int index, int e){
	LNode node = new LNode(e);
	if (index < 0 || index > size){
	    return false;}
	LNode x = head;
	for (int i = 0; i < index - 1; i++){
	    x = x.getNext();}
	x.setNext(node);
	if(index == size){
	    tail = node;}
	size++;
	return true;

    }

    public static void main(String[]args){
	MyLinkedList test = new MyLinkedList();
	System.out.println(test);
	test.add(0);
	System.out.println(test);
	test.add(1);
	System.out.println(test);
	test.add(3);
	System.out.println(test);
	test.add(2,2);
	System.out.println(test);
    }

}
