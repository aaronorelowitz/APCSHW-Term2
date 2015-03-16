import java.util.*;

public class LNode<T>{
    private T value;
    private LNode<T> next;

    public LNode(T val){
	value = val;
	next = null;
    }

    public LNode<T> getNext(){
	return next;}

    public T getValue(){
	return value;}

    public void setNext(LNode<T> newNext){
	next = newNext;}

    public void setValue(T newValue){
	value = newValue;
    }

    public String toString(){
	return "" +  value;}


}
