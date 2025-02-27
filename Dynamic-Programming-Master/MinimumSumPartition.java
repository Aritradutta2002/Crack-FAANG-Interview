import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MinimumSumPartition {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            int sum=0;
            for(int i:array)
                sum+=i;
            boolean [][]dp=new boolean[n][sum+1];
            for(int i=0;i<n;i++)
                dp[i][0]=true;
            dp[0][array[0]]=true;
            for(int i=1;i<n;i++)
                for(int j=1;j<=sum;j++){
                    if(j-array[i]>=0)
                        dp[i][j]=dp[i-1][j-array[i]];
                    if(dp[i-1][j])
                        dp[i][j]=true;                        
                }
            int min=Integer.MAX_VALUE;
            for(int i=0;i<=sum;i++){
                boolean found=false;
                for(int j=0;j<n;j++)
                    if(dp[j][i]==true){
                        found=true;
                        break;
                    }
                if(found)
                    min=Math.min(min, Math.abs(i-(sum-i)));
            }
            System.out.println(min);
        } 
    } 
}