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
	if(index != size){
	    LNode z = x.getNext();
	    node.setNext(z);}
	x.setNext(node);
	if(index == size){
	    tail = node;}
	size++;
	return true;
    }

    public int size(){
	return size;}

    public LNode get(int index){
	if (index < 0 || index > size){
	    return null;}
	LNode x = head;
	for (int i = 0; i < index; i++){
	    x = x.getNext();}
	return x;
    }

    
     public boolean set(int index, int e){
	 LNode node = new LNode(e);
	 if (index < 0 || index > size){
	     return false;}
	 LNode x = head;
	 for (int i = 0; i < index - 1; i++){
	     x = x.getNext();}
	 LNode z = x.getNext().getNext();
	 x.setNext(node);
	 node.setNext(z);
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
	test.add(4,4);
	System.out.println(test);
	System.out.println(test.get(0));
	System.out.println(test.get(1));
	System.out.println(test.get(2));
	System.out.println(test.get(3));
	System.out.println(test.get(4));
	test.set(3,8);
	System.out.println(test);
    }

}
