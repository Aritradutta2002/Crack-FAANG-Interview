import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StrangeTable {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        long t1 = Long.parseLong(r.readLine());
        while(t1-- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            long n = Long.parseLong(t.nextToken());
            long m = Long.parseLong(t.nextToken());
            long k = Long.parseLong(t.nextToken());

            long x = (long)Math.ceil((double)k / (double)n);
            long y = k % n;
            if(y == 0)
                y = n;
            long ans = (y - 1) * m;
            ans += x;
            System.out.println(ans);
        }
    }
        
}
