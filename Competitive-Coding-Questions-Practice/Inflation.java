import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Inflation {
    static long bs(long sum, long num, long k){
        long min = 0;
        long max = Integer.MAX_VALUE * 100L;
        long ans = Integer.MAX_VALUE * 100L;
        while(min <= max){
            long mid = min + (max - min) / 2;
            if((mid + sum) * k >= 100L * num){
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }

        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            float k = Float.parseFloat(t.nextToken());
            t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n ; i++)
               array[i] = Integer.parseInt(t.nextToken());

            long sum = array[0];
            long diff = 0;

            for(int i = 1; i < n; i++){
                long x = bs(sum, array[i], (int)k);
                diff +=x;
                sum +=x;
                sum += array[i];
            }

            System.out.println(diff);
        }
    }
        
}
