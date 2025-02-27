import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * MaximumSumOfProducts
 */
public class MaximumSumOfProducts {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        StringTokenizer t = new StringTokenizer(r.readLine());
        long []a = new long[n];
        for(int i = 0; i < n ; i ++)
            a[i] = Long.parseLong(t.nextToken());
        long[]b = new long[n];
        t = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; i ++)
            b[i] = Long.parseLong(t.nextToken());

        long[][]dp = new long[n + 1][n + 1];
        for(int i = 0; i < n; i ++)
            dp[i][i] = a[i] * b[i];
        long[]sum = new long[n + 1];
        for(int i = 1; i <= n; i ++)
            sum[i] = sum[i - 1] + a[i - 1] * b[i - 1];
        long max = sum[n];

        for(int i = n - 1; i >= 0; i --){
            for(int j = i; j < n; j ++){
                if(dp[i][j]!= 0)
                    continue;
                dp[i][j] = a[i] * b[j] + a[j] * b[i] + dp[i + 1][j - 1];
                
            }
        }

        // for(long []i : dp){
        //     for(long j : i)
        //         System.out.print(j + " ");
        //     System.out.println();
        // }

        for(int i = n - 1; i >= 0; i --){
            for(int j = i; j < n; j ++){
                dp[i][j] += sum[i] + sum[n] - sum[j + 1];
                max = Math.max(max, dp[i][j]);
                // System.out.println();
            }
        }
        // System.out.println("!!!!!!!!!!!!!!");
        // for(long []i : dp){
        //     for(long j : i)
        //         System.out.print(j + " ");
        //     System.out.println();
        // }

        System.out.println(max);

    }
    
    
}