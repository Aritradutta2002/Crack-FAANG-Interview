import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Calculus {
    static long calculate(long p, long q)
    {
        long mod = 998244353, expo;
        expo = mod - 2;
 
        // Loop to find the value
        // until the expo is not zero
        while (expo != 0)
        {
 
            // Multiply p with q
            // if expo is odd
            if ((expo & 1) == 1)
            {
                p = (p * q) % mod;
            }
            q = (q * q) % mod;
 
            // Reduce the value of
            // expo by 2
            expo >>= 1;
        }
        return p;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        long ans = calculate(1, 1);
        for(int i = 2; i <= n; i++){
            long num = i * 2 - 1;
            ans = (ans + calculate(1, num)) % 998244353; 
        }

        System.out.println((ans * 2) % 998244353);
    }
    

}
