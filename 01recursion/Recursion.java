public class Recursion implements hw1{

    public String name(){
	return "Orelowitz,Aaron";
    }
    
    public int fact(int n){
	int ans;
	if (n < 0){
	    throw new IllegalArgumentException();}
	if (n == 0){
	    return 1;  }  
	if (n!=1){
	    ans = fact(n-1) * n;}
	else{return 1;}
	return ans;
    }


    public int fib(int n){
	if (n < 0){
	    throw new IllegalArgumentException();}
	if (n == 0){
	    return 0;}
	return fibHelp(n-1, 1, 0);

    }


    public int fibHelp(int n, int ans1, int ans2){
	if (n == 0){
	    return ans1;
	}
	return fibHelp(n - 1, ans1+ans2, ans1);
    }


    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();}
	return sqrtHelp(n, 1);
    }

    public double sqrtHelp(double n, double guess){
	double x;
	x = ( n / guess + guess) * .5 ;
	if (Math.abs(guess - x) < 0.0000005)
	    return x;
	return sqrtHelp(n, x);
    }

}
