import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongestSimpleCycle {
    static long[]max;
    static long getMax(long[]c, long[]a, long[]b, int pos){
        if(pos == 0)
            return Math.abs(a[0] - b [0]);

        max[pos] = getMax(c, a, b, pos - 1) + 1L + c[pos] - Math.abs(a[pos] - b[pos]);
        // System.out.println(pos + " " + max[pos]);

        long ans = Math.max(max[pos], Math.abs(a[pos] - b[pos]));

        return (a[pos] == b[pos]) ? 0 : ans;


    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            long[]c = new long[n], b = new long[n], a = new long[n];
            StringTokenizer t = new StringTokenizer(r.readLine());
            for(int i = 0 ;i < n ;i ++)
                c[i] = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            t.nextToken();
            for(int i = 0; i < n - 1; i++)
                a[i] = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            t.nextToken();
            for(int i = 0; i < n - 1; i++)
                b[i] = Integer.parseInt(t.nextToken());
            a[n - 1] = 1;
            b[n - 1] = c [n - 1];

            max = new long[n];
            Arrays.fill(max, -1);

            getMax(c, a, b, n - 1);
            long m = 0;
            for(int i = 1; i < n; i++){
                m = Math.max(m, max[i] + (long)Math.abs(a[i] - b[i]));
            }
            // for(long i : max)
            //     System.out.print(i + " ");
            // System.out.println();
            // for(long i : a)
            //     System.out.print(i + " ");
            // System.out.println();
            // for(long i : b)
            //     System.out.print(i + " ");
            // System.out.println();
            System.out.println(m);
            

        }   
    }
        
}
