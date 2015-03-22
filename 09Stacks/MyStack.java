import java.util.*;

public class MyStack{
    
    public Object[] elements;
    public int amount;
    
    public MyStack(int x){
	amount = 0;
	elements = new Object[x];
    }

    public void push(Object x){
	if(amount < elements.length){
	    elements[elements.length - 1 - amount] = x;}

    }
	
}
