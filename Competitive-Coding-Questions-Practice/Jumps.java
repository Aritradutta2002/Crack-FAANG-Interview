import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jumps {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            long sum = 0;
            int count = 0, current = 1;
            while(sum < n){
                sum += current++;
                count++;
            }
            current = 1;
            // System.out.println(sum);
            long sum1 = sum;
            int count1 = count;
            for(int  i = count; i > 1; i --)
                if(sum - 1 - i >=n){
                    // System.out.println(sum);
                    sum -= 1 + i;
                }
            for(int  i = 1; i <= count; i ++)
                if(sum1 - 1 - i >=n){
                    // System.out.println(sum);
                    sum1 -= 1 + i;
                }
            if(sum != n)
                count++;
            if(sum1 != n)
                count1++;
            System.out.println(Math.min(count, count1));
            
        }
    }
        
}
