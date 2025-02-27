import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class NumberOfASppartments {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            int[][]dp=new int[n+1][3];
            for(int[]a:dp)
                Arrays.fill(a, -1);
            dp[0][0]=0;
            dp[0][1]=0;
            dp[0][2]=0;
            for(int i=0;i<n;i++){
                int[]list={3,5,7};
                if(dp[i][0]==-1)
                    continue;
                for(int j=0;j<3;j++){
                    if(i+list[j]<=n){
                        dp[i+list[j]][j]=dp[i][j]+1;
                        for(int k=0;k<3;k++){
                            if(k==j)
                                continue;
                            dp[i+list[j]][k]=dp[i][k];
                            
                        }
                    }
                }
            }
            // for(int[]i:dp){
            //     for(int j:i)
            //         System.out.print(j+" ");
            //     System.out.println();
            // }
            if(dp[n][0]==-1)
                System.out.println(-1);
            else
                System.out.println(dp[n][0]+" "+dp[n][1]+" "+dp[n][2]);
        } 
    } 
}
