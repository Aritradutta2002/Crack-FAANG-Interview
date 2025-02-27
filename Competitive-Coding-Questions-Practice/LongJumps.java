import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongJumps {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            Long []array = new Long[n];
            for(int i = 0; i < n; i++)
                array[i] = Long.parseLong(t.nextToken());
            for(int i = n - 1; i >= 0; i--)
                if(i + array[i] < n)
                    array[i] += array[(int)(i + array[i])] ;
            Long max = Long.MIN_VALUE;
            for(Long l : array)
                max = Math.max(l, max);
            System.out.println(max);
            
                
        }
    }
        
}
