import java.util.*;

public class MyLinkedList<E>{

    public LNode head;
    public LNode tail;
    public int size;
    
    public MyLinkedList(){
	head = null;
	tail = null;
	size = 0;}


    public String name(){
	return "orelowitz.aaron";}

    public String toString(){
	String ans = "[ ";
	LNode x = head; 
	while(x != null){
	    ans = ans + x.getValue() + ", ";
	    x = x.getNext();}
	return ans.substring(0, ans.length() - 2) + "]";
    }

    public boolean add(Object e){
	LNode node = new LNode(e);
	if(head == null){
	    head = node;}
	else{tail.setNext(node);}
	size = size + 1;
	tail = node;
	return true;}
    
    

    public boolean add(int index, Object e){
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
	if(index == 0){
	    head = node;}
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

    
     public boolean set(int index, object e){
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
	 if(index == 0){
	     head = node;}
	 size++;
	 return true;
     }
    

    public LNode remove(int index){
	if (index < 0 || index > size){
	    return null;}
	else{
	    LNode x = get(index);
	    if(index == 0){
		head = x.getNext();}
	    else if(index == size){
		(get(index-1)).setNext(null); 
		tail = get(index-1);}
	    else{get(index-1).setNext(x.getNext());}
	    size = size -1;
	    return x;
	}}

    public int indexOf(Object N){
	LNode x = head;
	if(x.getValue()==N){
	    return 0;}	
	for (int i = 0; i < size; i++){
	    x = x.getNext();
	    if(x.getValue()==N){
		return i + 1;}}
	return -1;}
    


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
	System.out.println(test.remove(3));
	System.out.println(test);
	System.out.println(test.remove(0));
	System.out.println(test);
    }

}
