import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class XorSums {
    static long FindXorSum(long arr[], int k, int n, int p) 
{ 
    // If the length of the array is less than k 
    if (n < k) 
        return 0; 
  
    // Array that will store xor values of 
    // subarray from 1 to i 
    long []x = new long[n]; 
    long result = 0; 
  
    // Traverse through the array 
    for (int i = 0; i < n; i++)  
    { 
  
        // If i is greater than zero, store 
        // xor of all the elements from 0 to i 
        if (i > 0) 
            x[i] = x[i - 1] ^ arr[i]; 
  
        // If it is the first element 
        else
            x[i] = arr[i]; 
  
        // If i is greater than k 
        if (i >= k - 1) 
        { 
            long sum = 0; 
  
            // Xor of values from 0 to i 
            sum = x[i]; 
  
            // Now to find subarray of length k 
            // that ends at i, xor sum with x[i-k] 
            if (i - k > -1) 
                sum ^= x[i - k]; 
  
            // Add the xor of elements from i-k+1 to i 
            sum %= p;
            result += sum; 
            result %= p;
        } 
    } 
  
    // Return the resultant sum; 
    return result; 
} 

    static int N = 1000001;  
 
    // Array to store inverse of 1 to N 
    static long[] factorialNumInverse = new long[N + 1]; 
    
    // Array to precompute inverse of 1! to N! 
    static long[] naturalNumInverse = new long[N + 1];
    
    // Array to store factorial of first N numbers 
    static long[] fact = new long[N + 1]; 
    
    // Function to precompute inverse of numbers 
    public static void InverseofNumber(int p) 
    { 
        naturalNumInverse[0] = naturalNumInverse[1] = 1; 
        
        for(int i = 2; i <= N; i++) 
            naturalNumInverse[i] = naturalNumInverse[p % i] *
                                    (long)(p - p / i) % p; 
    } 
    
    // Function to precompute inverse of factorials 
    public static void InverseofFactorial(int p) 
    { 
        factorialNumInverse[0] = factorialNumInverse[1] = 1; 
    
        // Precompute inverse of natural numbers 
        for(int i = 2; i <= N; i++) 
            factorialNumInverse[i] = (naturalNumInverse[i] * 
                            factorialNumInverse[i - 1]) % p; 
    } 
    
    // Function to calculate factorial of 1 to N 
    public static void factorial(int p) 
    { 
        fact[0] = 1; 
    
        // Precompute factorials 
        for(int i = 1; i <= N; i++)
        { 
            fact[i] = (fact[i - 1] * (long)i) % p; 
        } 
    } 
    
    // Function to return nCr % p in O(1) time 
    public static long Binomial(int N, int R, int p) 
    { 
        
        // n C r = n!*inverse(r!)*inverse((n-r)!) 
        long ans = ((fact[N] * factorialNumInverse[R]) % 
                        p * factorialNumInverse[N - R]) % p; 
        
        return ans; 
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int p = 998244353; 
        // InverseofNumber(p); 
        // InverseofFactorial(p); 
        // factorial(p); 
        
        int n = Integer.parseInt(r.readLine());
        StringTokenizer t = new StringTokenizer(r.readLine());
        long[]array = new long[n];
        for(int i = 0; i < n; i++)
            array[i] = Long.parseLong(t.nextToken());
        // boolean[][]bits = new boolean[n][32];
        // for(int i = 0; i < n; i++){
        //     String s = Long.toBinaryString(array[i]);
        //     int ptr = s.length() - 1;
        //     for(int j = 0; j < 32 && ptr >= 0; j ++)
        //         bits[i][j] = s.charAt(ptr --) == '1';
        // }
        // least significant at 0


        // int[]ones = new int[32];
        // for(int i = 0; i < 32; i++ )
        //     for(int j = 0; j < n; j++)
        //         if(bits[j][i])
        //             ones[i]++;

        long []ans = new long[n + 1];
        // for(int size = 1; size <= n; size ++){
        //     long sum = 0;
        //     for(int x = 1; x <= size; x += 2){
        //         int y = size - x;
        //         for(int i = 0; i < 32; i++){
        //             int xt = ones[i];
        //             int yt = n - xt;
        //             if(x > xt || y > yt)
        //                 continue;

        //             long a1 = Binomial(xt, x, p);
        //             long a2 = Binomial(yt, y, p);
        //             sum += (((a1 * a2) % p) * Math.pow(2, i)) % p;
        //             sum = sum % p;
        //         }
        //     }
        //     ans[size] = sum;
        // }

        for(int i = 1; i <= n; i ++)
            ans[i] = FindXorSum(array, i, n, p);
        for(int i = 0; i <= n; i++)
            ans[i] = (ans[i] + ans[i -1]) % p;

        int q = Integer.parseInt(r.readLine());
        while(q-- > 0){
            int e = Integer.parseInt(r.readLine());
            System.out.println(ans[e]);
        }

    }
        
}
