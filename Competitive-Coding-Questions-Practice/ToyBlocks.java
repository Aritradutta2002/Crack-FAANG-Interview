import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ToyBlocks {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1-->0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i=0;i<n;i++)
                array[i] = Integer.parseInt(t.nextToken());

            long sum = 0;
            int max = Integer.MIN_VALUE;
            for(int i:array)
                max = Math.max(max, i);
            for(int i:array)
                if(i!=max)
                    sum+=i;
            if(max == 0||n==2)
                System.out.println(0);
            else if(max > sum){
                System.out.println(max - sum);
            }
            else{
                System.out.println(Math.min(sum%max, (max - sum%max)%max));
            }
        }
    }
        
}
