import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

 class WatchingCPL {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int k = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0;i < n; i++)
                array[i] = Integer.parseInt(t.nextToken());
            
            Arrays.sort(array);

            int[][]dp = new int[k + 1][k + 1];
                for(int[]i : dp)
                Arrays.fill(i, Integer.MAX_VALUE);
            dp[0][0] = 0;
            // int ptr = n - 1;
            int ans = Integer.MAX_VALUE;

            for(int i = 0; i <= k ; i++){
                for(int j = 0; j <= k ; j ++){
                    if(dp[i][j] == Integer.MAX_VALUE)
                        continue;
                    int ptr = n - dp[i][j] - 1;
                    if(ptr < 0)
                        continue;
                    int x1 = Math.min(array[ptr] + i, k);
                    int y1 = j;
                    int x2 = i;
                    int y2 = Math.min(array[ptr] + j, k);

                    if(x1 >= k && y1 >= k ){
                        ans = Math.min(dp[i][j] + 1, ans);
                    } else {
                        dp[x1][y1] = Math.min(dp[i][j] + 1, dp[x1][y1]);
                    }

                    if(x2 >= k && y2 >= k ){
                        ans = Math.min(dp[i][j] + 1, ans);
                    } else {
                        dp[x2][y2] = Math.min(dp[i][j] + 1, dp[x2][y2]);
                    }
                }
            }
            ans = (ans == Integer.MAX_VALUE) ? -1 : ans;
            System.out.println(ans);
        }
    }
        
}
