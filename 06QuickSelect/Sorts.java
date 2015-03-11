import java.util.*;

public class Sorts{

    private Random random;


    public int quickSelect(int[]ary, int num){
	return quickSelectHelp(ary, 0, ary.length - 1, num);
    }
    
    public int quickSelectHelp(int[]ary, int si, int ei, int num){
	    int smallestopen=si;
	    int biggestopen = ei;
	    random = new Random();
	    int[]D = new int[ary.length];
	    for (int i = 0; i < ary.length; i++){
		if ( i < si || i > ei){
		    D[i] = ary[i];}
	    }
	    int x = random.nextInt(ei - si + 1);
	    System.out.println(ary[x]);
	    for (int i = si; i <= ei; i++){
		System.out.println(Arrays.toString(D));
		if(ary[i] < ary[si + x]){
		    D[smallestopen] = ary[i];
		    smallestopen = smallestopen + 1;}
		if(ary[i] > ary[si + x]){
		    D[biggestopen] = ary[i];
		    biggestopen = biggestopen - 1;}
	    }
	    D[smallestopen] = ary[si +x];
	    if(num - 1 < smallestopen){
		return quickSelectHelp(D, si, smallestopen - 1, num);}
	    if(num - 1 == smallestopen){
		return D[smallestopen];
	    }else{return quickSelectHelp(D, smallestopen + 1, ei, num);}  	    	   
    }




    
    public void partition(int[]ary, int si, int ei){
	int smallestopen=si;
	int biggestopen = ei;
	random = new Random();
	int[]D = new int[ary.length];
	for (int i = 0; i < ary.length; i++){
	    if ( i < si || i > ei){
		D[i] = ary[i];}
	}
	int x = random.nextInt(ei - si + 1);
	System.out.println(ary[x]);
	for (int i = si; i <= ei; i++){
	    System.out.println(Arrays.toString(D));
	    if(ary[i] < ary[x]){
		D[smallestopen] = ary[i];
		smallestopen = smallestopen + 1;}
	    if(ary[i] > ary[x]){
		D[biggestopen] = ary[i];
		biggestopen = biggestopen - 1;}
	}
	D[smallestopen] = ary[x];

	 System.out.println(Arrays.toString(D));

    }


     public static void quickSort(int[]ary){
	quickSortHelp(ary, 0, ary.length-1);
    }

    public static void quickSortHelp(int[] ary, int si, int ei){
	if (!(si >= ei)){
     
	int pivot = partition2(ary, si, ei);
	quickSortHelp(ary, si, pivot-1);
	quickSortHelp(ary, pivot+1, ei);}
    }

    public static int partition2(int[]ary, int si, int ei){
	int start = si;
	int end = ei; 
	int ri = start + (int)(Math.random()*(end-start+1));
	int pivot = ary[ri];
	int x,y;
	while (si != ei){
	    if (ary[si] == pivot){
		x = ary[si];
		y = ary[si + 1];
		ary[si+1] = x;
		ary[si] = y;
	    }
	    if (ary[ei] == pivot){
		x = ary[ei];
		y = ary[ei-1];
		ary[ei-1] = x;
		ary[ei] = y;
	    }
	    if (ary[si] > ary[ei]){
		x = ary[si];
		y = ary[ei];
		ary[ei] = x;
		ary[si] = y;
	    }
	    if (ary[ei] > pivot){
		ei--;
	    }
	    if (ary[si] < pivot){
		si++;
	    }
	}
	return si;
     }






    public static void main(String[]args){
	int[]a = {10,9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
	int[]b = {10,9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
	int[]c = {-5,17,9,3,6,1,-7,14,8,4,0,5,2,7,-2,10,16,35};
	int[]d = {-5,17,9,3,6,1,-7,14,8,4,0,5,2,7,-2,10,16,35};
	Sorts.quickSort(a);
	Sorts.quickSort(c);
	Arrays.sort(b);
	Arrays.sort(d);
	if (Arrays.equals(a, b)){
	    System.out.println("True"+ Arrays.toString(a));
	}else{
	    System.out.println("noooooo");
	}
	if (Arrays.equals(c, d)){
	    System.out.println("True"+ Arrays.toString(c));
	}else{
	    System.out.println("noooooo");
	}
    }
    } 
