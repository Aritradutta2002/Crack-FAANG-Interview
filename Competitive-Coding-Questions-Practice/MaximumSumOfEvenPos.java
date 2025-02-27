import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaximumSumOfEvenPos{
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            long[]array = new long [n];
            for(int i = 0; i < n; i++)
                array[i] = Integer.parseInt(t.nextToken());

            long [][] dp = new long[n + 1][3];
            
            for(long[]i : dp)
                Arrays.fill(i, -1);
            dp[0][0] = 0;
            dp[0][1] = 0;
            dp[0][2] = 0;
            
            for(int i = 0; i < n; i++){
                if(i % 2 == 0){
                    dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][0]);
                    
                    dp[i + 1][1] = Math.max(dp[i + 1][1] , dp[i][1] + array[i]);
                    dp[i + 1][2] = Math.max(dp[i + 1][2] , dp[i][1]);
                    if(i + 2 < n)
                        dp[i + 2][2] = Math.max(dp[i + 2][2],dp[i][1] + array[i] );
                    // dp[i + 1][2] = Math.max(dp[i + 1][2] , dp[i][1] + array[i]);
                    dp[i + 1][2] = Math.max(dp[i + 1][2] , dp[i][2]);
                }
                else{
                    dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][0] + array[i]);
                    dp[i + 1][1] = Math.max(dp[i + 1][1] , dp[i][1]);
                    if(i + 2 < n)
                        dp[i + 2][1] = Math.max(dp[i + 2][1],dp[i][0] + array[i] );
                    dp[i + 1][1] = Math.max(dp[i + 1][1] , dp[i][0]);
                    dp[i + 1][2] = Math.max(dp[i + 1][2] , dp[i][2] + array[i]);
                }
            }
            for(int i =0; i < 3; i++){
                for(int j = 0; j < n; j++)
                    System.out.print(dp[j][i]+" ");
                System.out.println();
            }
            System.out.println(Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]));


            

        }
    }
    
}