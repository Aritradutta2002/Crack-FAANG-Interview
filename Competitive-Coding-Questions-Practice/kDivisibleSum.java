import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kDivisibleSum {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            long n = Integer.parseInt(t.nextToken());
            long k = Integer.parseInt(t.nextToken());
            long num = (n / k) * k;
            num += (n % k == 0) ? 0 : k;
            long ans = num /n;
            ans += (num % n == 0) ? 0 : 1;
            System.out.println(ans);

        }
    }
        
}
