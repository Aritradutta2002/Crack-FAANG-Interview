import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class MortalCombatTower{
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String []data=r.readLine().split(" ");
            int[]array=new int[n+1];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            int[][]dp=new int[n+1][2];
            for(int []i:dp)
                Arrays.fill(i,Integer.MAX_VALUE);
            dp[0][1]=array[0];
            if(n>1)
                dp[1][1]=array[0]+array[1];
            for(int i=0;i<n;i++){
                if(dp[i][0]!=Integer.MAX_VALUE){
                    if(i+1<=n)
                        dp[i+1][1]=Math.min(dp[i+1][1], dp[i][0]+array[i+1]);
                    if(i+2<=n)
                        dp[i+2][1]=Math.min(dp[i+2][1], dp[i][0]+array[i+1]+array[i+2]);
                }
                if(dp[i][1]!=Integer.MAX_VALUE){
                    if(i+1<=n)
                        dp[i+1][0]=Math.min(dp[i+1][0], dp[i][1]);
                    if(i+2<=n)
                        dp[i+2][0]=Math.min(dp[i+2][0], dp[i][1]);
                }
            }
            // for(int i=0;i<2;i++){
            //     for(int j=0;j<=n;j++)
            //         System.out.print(dp[j][i]+" ");
            //     System.out.println();
            // }
            System.out.println(Math.min(dp[n][0], dp[n][1]));
                        
        }
    } 
}