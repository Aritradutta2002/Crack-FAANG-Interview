import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GcdSum {
    public static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
         
        return gcd(b%a, a);
    }
    static long getSum(long n){
        String s = Long.toString(n);
        long sum = 0;
        for(char c : s.toCharArray())
            sum += Long.parseLong(Character.toString(c));

        return sum;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            long n = Long.parseLong(r.readLine());
            while(gcd(n, getSum(n)) == 1)
                n++;

            System.out.println(n);

            
        }


    }
        
}
