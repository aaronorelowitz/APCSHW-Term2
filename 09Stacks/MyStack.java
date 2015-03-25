import java.util.*;

public class MyStack<E> extends MyLinkedList<E> {
    
    public Object push(Object x) {
	add(x);
	return x;
    }

    public Object pop() {
	return remove(size-1);
    }

    public Object peek() throws NoSuchElementException {
	try {
	    return get(size-1);
	} catch (IndexOutOfBoundsException e) {
	    throw new NoSuchElementException();
	}
    } 
}
