 public class MyHeap{

    private int[]heap;
    private boolean Max; 

    public MyHeap(){
	heap = new int[10];
	Max = true;
    }

    public MyHeap(boolean isMax){
	heap = new int[10];
	Max = isMax;
    }

    public void resize(){
	int[]newHeap = new int[heap.length * 2];
	for(int i = 0; i < heap.length; i++){
	    newHeap[i] = heap[i];}
    }

}
