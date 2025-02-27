import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * ThreeSwimmers
 */
public class ThreeSwimmers {

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            long p = Long.parseLong(t.nextToken());
            long a = Long.parseLong(t.nextToken());
            long b = Long.parseLong(t.nextToken());
            long c = Long.parseLong(t.nextToken());
            long ans = Long.MAX_VALUE;
            
            ans = Math.min(ans, (a - p % a) % a);
            ans = Math.min(ans, (b - p % b) % b);
            ans = Math.min(ans, (c - p % c) % c);

            System.out.println(ans);


        }
    }
    
}