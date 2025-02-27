import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EvenPairSum {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            long a = Integer.parseInt(t.nextToken());
            long b = Integer.parseInt(t.nextToken());
            long even = a / 2;
            even *= b / 2;
            long odd = a / 2 + a % 2;
            odd *= b / 2 + b % 2;
            System.out.println(even + odd);
        }
    }
        
}
