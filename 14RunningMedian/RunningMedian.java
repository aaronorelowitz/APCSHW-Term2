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
}
