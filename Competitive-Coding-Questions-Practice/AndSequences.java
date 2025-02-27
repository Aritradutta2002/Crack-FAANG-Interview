import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AndSequences {

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        long N = 1000000000 + 7;
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            
            for(int i = 0; i < n ;i++){
                array[i] = Integer.parseInt(t.nextToken());
                // ans = ans & array[i];
            }
            int ans = array[0];
            for(int i : array)
                ans = i & ans;
            long cnt = 0;
            for(int i : array)
                if(ans == i)
                    cnt++;
            // System.out.println(cnt + " " + ans);
            long a = (cnt * (cnt - 1)) % N;

            for(int i = n - 2; i > 1; i --)
                a = (a * i ) % N;
            System.out.println(a);

        }
    }

}
