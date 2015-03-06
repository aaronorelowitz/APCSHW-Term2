 import java.util.*;

public class QuickSelect{

    private Random random;
    
    public void partition(int[]ary, int si, int ei){
	int smallestopen=si;
	int biggestopen = ei;
	random = new Random();
	int[]D = new int[ary.length];
	for (int i = 0; i < ary.length; i++){
	    if ( i < si || i > ei){
		D[i] = ary[i];}
	}
	int x = random.nextInt(ei - si);
	for (int i = si; i < ary.length; i++){
	    if(ary[i] < ary[x]){
		D[smallestopen] = ary[i];
		smallestopen = smallestopen + 1;}
	    if(ary[i] > ary[x]){
		D[biggestopen] = ary[i];
		biggestopen = biggestopen - 1;}
	}
	D[smallestopen] = ary[x];

    }


}

