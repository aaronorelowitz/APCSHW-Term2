public class RunningMedian{

    public MyHeap MinHeap;
    public MyHeap MaxHeap;

    public RunningMedian(){
	MinHeap = new MyHeap(false);
	MaxHeap = new MyHeap(true);}

    public Sting name(){
	return "aaron.orelowitz"}

    

    public int getMedian(){
	if(MinHeap.size() == 0 && MaxHeap.size() == 0){
	    return 0;}
	if(MinHeap.size() > MaxHeap.size()){
	    return MinHeap.peak();}
	if(MaxHeap.size() > MinHeap.size()){
	    return MaxHeap.peak();}
	else{
	    MaxHeap.peak() + MinHeap.peak() / 2
	}
    }

    public void add(int val) {
	if (value < getMedian()) {
	    MaxHeap.add(value);
	} else {
	    MinHeap.add(value);
	}
	evenOut();
    }
    
    public void evenOut(){
	while (math.abs(MinHeap.size() - MaxHeap.size()) > 1){
	    if(MinHeap.size() - MaxHeap.size() > 1){
		MaxHeap.add(MinHeap.remove())}
	    else{MinHeap.add(MaxHeap.remove())}}
    }
    
}
