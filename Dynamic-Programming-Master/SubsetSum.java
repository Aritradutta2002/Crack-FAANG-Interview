import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class SubsetSum {
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
            boolean[][]dp=new boolean[sum/2+2][n];
            Arrays.fill(dp[0],true);
            if(array[0]<=sum/2)
                dp[array[0]][0]=true;
            for(int i=1;i<n;i++)
                for(int j=1;j<sum/2+1;j++){
                    if(j-array[i]>=0)
                        dp[j][i]=dp[j-array[i]][i-1];
                    if(dp[j][i-1])
                        dp[j][i]=true;
                }
            boolean isFound=false;
            for(int i=0;i<n;i++)
                if(dp[sum/2][i])
                    isFound=true;
            if(isFound&&sum%2==0)
                System.out.println("YES");
            else System.out.println("NO");
            
        } 
    } 
}