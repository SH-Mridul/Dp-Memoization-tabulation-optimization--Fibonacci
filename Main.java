package Problem;

public class Main {
	
	public static void main(String[] args) {
		//System.out.println(fib(400));
		System.out.println(fibo_optimization(6));
	}
	
	//normal
	public static int fibo(int n)
	{
		if(n>2)
			return n;
		return fibo(n-1)+fibo(n-2);
	}
	
	//this for memoization and tabulation
	public static int fib(int n)
	{
		int arr[] = new int[n+1];
		//return fib_memoization(arr,n);
		return fib_tabulation(arr,n);
	}
	
	//memoization
	public static int fib_memoization(int arr[],int n)
	{
		//base call
		if(n<2)
			return arr[n] = n;
		
		//find stored value and return
		if(arr[n] != 0)
			return arr[n];
		
		//time complexity O(2N) and space complexity O(N)
		int ans =  fib_memoization(arr,n-1)+fib_memoization(arr,n-2);
		
		//memoization and return
		return arr[n] = ans;
	}
	
	
	
	// tebulation
	public static int fib_tabulation(int arr[],int N)
	{
		//time complexity O(N) and space complexity O(N) +lambda
		for(int n = 0; n<= N ; n++)
		{
			if(n<=1)
			{
				arr[n] = n;
				continue;
			}
			
			
			 arr[n] =  arr[n-1]+arr[n-2];
		}
		
		return arr[N];
	}
	
	
	//optimization(space)
	public static int fibo_optimization(int N)
	{
		int a  = 0, b = 1;
		
		//0 1 1 2 3 5 8 13 21 34 55
		//a+b=c
		for(int n = 1; n <= N; n++) //time complexity O(N) and space complexity O(1)
		{
			int c = a+b;
			a = b;
			b = c;
		}
		
		return a;
	}
}

