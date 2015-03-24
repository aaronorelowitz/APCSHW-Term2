 import java.util.*;

public class MyQueue<E> extends MyLinkedList<E> {
    
    public Object dequeue() {
	return remove(0);
    }

    public boolean enqueue(Object n){
	add(n);
	return true;
    }
}

