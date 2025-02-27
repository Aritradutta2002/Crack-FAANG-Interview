import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberBox {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 --> 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int m = Integer.parseInt(t.nextToken());
            int[][]array = new int[n][m];
            for(int i=0;i<n;i++){
                t = new StringTokenizer(r.readLine());
                for(int j=0;j<m;j++)
                    array[i][j] = Integer.parseInt(t.nextToken());
            }
            
            int neg = 0;
            int min = Integer.MAX_VALUE;
            long sum = 0;
            for(int []i:array)
                for(int j:i){
                    min = Math.min(min, Math.abs(j));
                    sum += Math.abs(j);
                    if(j < 0)
                        neg++;
                }
            if(neg % 2 ==0)
                System.out.println(sum);
            else
                System.out.println(sum - 2 * min);
        }
    }
        
}
