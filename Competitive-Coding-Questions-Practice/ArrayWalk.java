import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayWalk {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int k = Integer.parseInt(t.nextToken());
            int z = Integer.parseInt(t.nextToken());
            
            t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n; i++)
                array[i] = Integer.parseInt(t.nextToken());
            long sum = array[0];
            int pos = 0;
            
            for(int i = 1; i <= k ; i++)
                sum += array[pos ++ + 1];
            // System.out.println(sum);
            long [] maxSum = new long [n];
            for(int i = 1; i < n; i ++)
                maxSum[i] = Math.max(maxSum[i - 1], array[i] + array[i - 1]);

            while(z > 0 && pos - 2 >= 0){
                if(array[pos] +array[pos - 1] < maxSum[pos - 2]){
                    sum -= array[pos] + array[pos - 1];
                    sum += maxSum[pos - 2];
                    z--;
                    pos -= 2;
                }
                else{
                    break;
                }
            }
            // if(k % 2 == 1 && pos - 1 >= 0 && pos + 1 < n)
            //     sum += Math.max(array[pos - 1], array[pos + 1]);
            // else if(k % 2 == 1 && pos - 1 < 0 && pos + 1 < n)
            //     sum += array[pos + 1];
            // else if(k % 2 == 1 && pos - 1 >= 0 && pos + 1 >= n)
            //     sum += array[pos - 1];
            System.out.println(sum);

        }
    }
        
}
