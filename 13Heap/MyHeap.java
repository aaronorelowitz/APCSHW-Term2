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
	heap = newHeap;
    }
    
    public void add(int num){
	heap[0] = heap[0] + 1;
	if(heap.length <= heap[0]){
	    resize();}
	heap[heap[0]] = num;
	}
    }


}
