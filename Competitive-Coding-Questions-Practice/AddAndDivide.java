import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AddAndDivide {
    static long get(long a, long b){
        long c = 0;
        if(b == 1){
            c++;
            b++;
        }
        while(a >= 1){
            a /= b;
            c++;
        }
        return c;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            long a = Integer.parseInt(t.nextToken());
            long b = Integer.parseInt(t.nextToken());
            long c = Integer.MAX_VALUE;
            System.out.println(c);
        }
    }
        
}
