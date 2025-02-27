import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PermutationBySum {
    public static void main(String[] args) throws IOException{
        BufferedReader rBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(rBufferedReader.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(rBufferedReader.readLine());
            int n = Integer.parseInt(t.nextToken());
            int l = Integer.parseInt(t.nextToken());
            int r = Integer.parseInt(t.nextToken());
            int s = Integer.parseInt(t.nextToken());
            
            int[][]dp = new int[n + 1][n * n];

            for(int []i : dp)
                Arrays.fill(i, -1);

            Arrays.fill(dp[0], 0);
            

        }
    }
        
}
