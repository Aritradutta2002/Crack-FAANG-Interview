import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimumGridPath {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n + n % 2];
            for(int i = 0; i <n ; i++)
                array[i] = Integer.parseInt(t.nextToken());
            if(n % 2 == 1)
                array[n] = array[ n - 2];

            int[]min = new int[n + n % 2];

            min[0] = array[0];
            min[1] = array[1];
            for(int i = 2; i < n + n % 2; i += 2)
                min[i] = Math.min(min[i - 2], array[i]);
            for(int i = 3; i < n + n % 2; i += 2)
                min[i] = Math.min(min[i - 2], array[i]);
            long []sum = new long[n + n % 2];

            sum[0] = array[0];
            sum[1] = array[1];
            for(int i = 2; i < n + n % 2; i += 2)
                sum[i] = (sum[i - 2] +  array[i]);
            for(int i = 3; i < n + n % 2; i += 2)
                sum[i] = (sum[i - 2] + array[i]);

            long m= Long.MAX_VALUE;

            for(int i = 0; i < n - n % 2; i += 2){
                long ans = 0;
                ans += sum[i] + sum[i + 1];
                ans -= min[i] + min[i + 1];
                long count = i / 2;
                ans += (n - count) * min[i];
                ans += (n - count) * min[i + 1];
                m = Math.min(m, ans);

            }
            for(int i = 0; i + 2 < n; i += 2){
                
                    long ans = 0;
                    ans += sum[i] + sum[i + 1];
                    ans -= min[i + 1];
                    long count = i / 2;
                    ans += (n - count - 1) * array[i + 2];
                    ans += (n - count) * min[i + 1];
                    m = Math.min(m, ans);
            }
            System.out.println(m);

        }
    }
        
}
