import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ShortestCommonSubsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            String s1=data[0];
            String s2=data[1];
            int[][]dp=new int[s1.length()+1][s2.length()+1];
            for(int i=1;i<s1.length()+1;i++)
                for(int j=1;j<s2.length()+1;j++)
                    if(s1.charAt(i-1)==s2.charAt(j-1))
                        dp[i][j]=dp[i-1][j-1]+1;
                    else
                        dp[i][j]=Integer.max(dp[i-1][j],dp[i][j-1]);
            System.out.println(s1.length()+s2.length()-dp[s1.length()][s2.length()]);
        }
    } 
}