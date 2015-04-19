import java.util.*;
import java.io.*;

public class MyDeque<T> {

    private T[] list;
    private int[] weights;
    private int start, tail ,size;

    public MyDeque() {
	list = (T[]) (new Object[10]);
        weights = new int[10];
        start = 0;
	size = 0;
    }
    
    public MyDeque(int len) {
        list = (T[]) new Object[len];
	weights = new int[len];
        start = 0;
	size = 0;
    }


    public void addFirst(T value) {
	if (size == list.length)
	    expand();
        list[(list.length + start - 1) % list.length] = value;
	start = (list.length + start - 1) % list.length;
	size += 1;
    }

    public void addLast(T value) {
	if (size == list.length)
	    expand();
        list[(start + size) % list.length] = value;
	size += 1;
    }


    public void add(T value, int priority) {
	if (size == list.length)
	    expand();
        list[(start + size) % list.length] = value;
	weights[(start + size) % list.length] = priority;
	size += 1;
    }
    

    public Object removeFirst() {
	if (size == list.length / 4)
	    contract();
        Object ans = list[start];
	list[start] = null;
	start = (list.length + start + 1) % list.length;
	size -= 1;
	return ans;
    }

    public Object removeLast() {
	if (size == list.length / 4)
	    contract();
        Object ans = list[(start + size - 1) % list.length];
	list[(start + size - 1) % list.length] = null;
	size -= 1;
	return ans;
    }

    public T getFirst(){
	return list[start];
    }


    public T getLast(){
	return list[(start + size) % list.length];
    }

    private void expand() {
	T[] newlist = (T[])new Object[list.length * 2];
	for (int i = 0; i < list.length; i++) {
	    newlist[i] = list[(start + i) % list.length];
	}
        list = newlist;

	int[] newweights = new int[weights.length * 2];
	for (int i = 0; i < weights.length; i++) {
	    newweights[i] = weights[(start + i) % weights.length];
	}
        weights = newweights;
	start = 0;
    }

    private void contract() {
        T[] newlist = (T[])new Object[list.length / 2];
	for (int i = 0; i < list.length; i++) {
	    newlist[i] = list[(start + i) % list.length];
	}
	list = newlist;

	int[] newweights = new int[weights.length / 2];
	for (int i = 0; i < weights.length; i++) {
	    newweights[i] = weights[(start + i) % weights.length];
	}
	weights = newweights;

	start = 0;
    }
}
