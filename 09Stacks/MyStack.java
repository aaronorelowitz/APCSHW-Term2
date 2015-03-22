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
	    elements[elements.length - 1 - amount] = x;
	    amount = amount + 1;}

    }

    public Object pop(){
	Object x = elements[elements.length - amount];
	elements[elements.length - amount] = null;
	amount = amount - 1;
	return x;
    }

    public Object peek(){
        return elements[elements.length - amount];
    }
    
	
}
