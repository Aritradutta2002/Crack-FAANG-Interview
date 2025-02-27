import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NastiaAndNearlyGoodNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            long a = Integer.parseInt(t.nextToken());
            long b = Integer.parseInt(t.nextToken());
            if(b <= a && a % b == 0){
                System.out.println("NO");
                continue;
            }
            long n1 = a;
            long n2 = a * (b - 1);
            long n3 = a * b;
            if(true){
                n1 = a;
                n2 = ((a) * ((long)Math.pow(b, 2) - 1L));
                n3 = (a * b * b);
            } 
            System.out.println("YES");
            System.out.println(n1 + " " + n2 + " " + n3);
        }
    }
        
}
