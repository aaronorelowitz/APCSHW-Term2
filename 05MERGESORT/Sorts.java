import java.util.*;
public class Sorts{
 public int[] merge(int[] a, int[] b){
 	int[] c = new int[a.length+b.length];
	 int x=0;
	 int y=0;
	 int z=0;
	 while(y<b.length||x<a.length){
	     if(y == b.length){
		     c[z]=a[x];
	 	     z++;
		      x++;
	     } else if (x == a.length){
	     	c[z]=b[y];
	     	z++;
	     	y++;
	     } else if (a[x] > b[y]){
	 	c[z]=b[y];
	 	z++;
	 	y++;
	     } else {
	 	c[z]=a[x];
	 	z++;
	 	x++;
	     }
	  } 
	 return c;
     }

 public static void mergesort(int[] a){
	 if (a.length >  1){
	     int[] b = Arrays.copyOfRange(a, 0, a.length/2);
	     int[] c = Arrays.copyOfRange(a, a.length/2, a.length);
	     int[] a1 = mergesort(b);
	     int[] a2 = mergesort(c);
	     return merge(a1,a2);
	 } else {
	     return a;
	 }
     }
     }
