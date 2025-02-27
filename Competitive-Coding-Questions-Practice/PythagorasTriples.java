import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythagorasTriples {
    static long getMax(int n){
        long ans = 0;
        long min = 0, max = Integer.MAX_VALUE;
        while(min <= max){
            long mid = min + (max - min) / 2;
            if(Math.pow(mid, 2) + Math.pow(mid + 1, 2) <= n){
                ans = mid;
                min = mid + 1;
            } else
                max = mid - 1;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            System.out.println(getMax(n));
        }
    }
        
}
