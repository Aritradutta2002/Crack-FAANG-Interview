import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ConsequtiveDeletions {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int k = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i <n ; i++){
                array[i] = Integer.parseInt(t.nextToken());
            }
            int[]sum = new int[n + 1];
            for(int i = 1; i <=n; i++)
                sum[i] = sum[i - 1] + array[i - 1];
            int minPos = 0;
            int min = sum[n];
            for(int i = 0; i + k <= n; i ++){
                // System.out.println(i + " " + (sum[i + k] - sum[i]));
                if(sum[i + k] - sum[i] < min){
                    min = sum[i + k] - sum[i];
                    minPos = i;
                }
            }
                
            long a = sum[n] - min;
            while(min > 0)
                a += min--;
            System.out.println(a);
            
        }
    }
        
}
