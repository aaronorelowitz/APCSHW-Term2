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


    public String name(){
	return "aaron.orelowitz";}

    private void Switch(int x, int y) {
	int tmp = heap[x];
	heap[x] = heap[y];
	heap[y] = tmp;
    }

    private void SwitchUp(int x){
	if (x == 1) {
	    return;
	} else if (compare(x, x/2)) {
	    Switch(x, x/2);
	    SwitchUp(x/2);
	}

    }  


    public boolean compare(int x, int y){
	if(Max){
	    return (heap[x] > heap[y]);}
	else{return (heap[x] < heap[y]);}
    }

    
    
    public void resize(){
	int[]newHeap = new int[heap.length * 2];
	for(int i = 0; i < heap.length; i++){
	    newHeap[i] = heap[i];}
	heap = newHeap;
    }

    public int size(){
	return heap[0];}
    
    public void add(int num){
	heap[0] = heap[0] + 1;
	if(heap.length <= size()){
	    resize();}
	heap[size()] = num;
	SwitchUp(size());
    }
    
    public int remove() {
	int tmp = heap[1];
	heap[1] = heap[size()];
        SwitchDown(1);
	heap[0]= heap[0] - 1;
	return tmp;
    }
    
    private void SwitchDown(int x) {
	if (x*2 > size()) {
	    return;
	}
	if (!compare(x, x*2)) {
	    Switch(x, x*2);
	    SwitchDown(x*2);
	}
  }

    public int peak(){
	return heap[1];}

    public String toString(){
	string ans = "";
	for(int x = 0; x < heap.length(); x++){
	    ans = ans + heap[x];}
	return ans;
    }



}
