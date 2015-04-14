public class MyDeque {
    private Object[] list;
    private int[] weights
    private int start, size;

    public MyDeque(int len) {
        list = new Object[len];
	weights = new int[len];
	start = 0;
	size = 0;
    }


    public void addFirst(Object value) {
	if (size == list.length)
	    expand();
        list[(list.length + start - 1) % list.length] = value;
	start = (list.length + start - 1) % list.length;
	size += 1;
    }

    public void addLast(Object value) {
	if (size == list.length)
	    expand();
        list[(start + size) % list.length] = value;
	size += 1;
    }


    public void add(Object value, int priority) {
	if (size == list.length)
	    expand();
        list[(start + size) % list.length] = value;
	weights[(start + size) % list.length] = value;
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

    public Object getFirst(){
	return list[start];
    }


    public Object getLast(){
	return list[(start + size) % list.length];
    }




    private void expand() {
	Object[] newlist = new Object[list.length * 2];
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
	Object[] newlist = new Object[list.length / 2];
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
