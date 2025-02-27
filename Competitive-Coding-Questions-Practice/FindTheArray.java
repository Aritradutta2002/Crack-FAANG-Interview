import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindTheArray{
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int []array = new int[n];
            for(int i = 0; i < n ;i ++)
                array[i] = Integer.parseInt(t.nextToken());
            long sum = 0;
            for(int i : array)
                sum += i;
            for(int ans = Math.max(0, (int)(sum / n) - 1); ans < (int)(sum / n) + 1; ans ++){
                boolean check = true;
                for(int i : array)
                    if(Math.abs(ans - i) * 2 > sum){
                        check = false;
                        break;
                    }
                if(check){
                    Arrays.fill(array,ans);
                    StringBuilder b = new StringBuilder();
                    for(int i = 0 ;i < n; i ++){
                        b.append(array[i]);
                        b.append(" ");
                    }
                    System.out.println(b);
                    break;
                }
            }
            


        }
    }
    
}