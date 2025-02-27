import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Education {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int c = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            int[]a = new int[n];
            for(int i = 0; i < n; i ++)
                a[i] = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            int[]b = new int[n - 1];
            for(int j = 0; j < n - 1; j ++)
                b[j] = Integer.parseInt(t.nextToken());

            int min = Integer.MAX_VALUE;
            int days = 0;
            int ex = 0;
            for(int i = 0; i < n - 1; i ++){
                int val = (c - ex) / (a[i]);
                val += ((c - ex) % ( a[i]) == 0) ? 0 : 1;

                int learn = (b[i] - ex)  / (a[i]) + 1;
                learn += ((b[i] - ex) % ( a[i]) == 0) ? 0 : 1;
                ex = (learn - 1)* (a[i]) - b[i] + ex;

                min = Math.min(val + days, min);
                days += learn;
                
            }
            int val = (c - ex) / (a[n - 1]);
            val += ((c - ex) % ( a[n - 1]) == 0) ? 0 : 1;
            min = Math.min(val + days, min);

            System.out.println(min);
        }
    }
        
}
