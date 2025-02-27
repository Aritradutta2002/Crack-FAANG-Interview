import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class LongestRepeatingSubsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            r.readLine();
            String s1=r.readLine();
            String s2=s1;
            int[][]dp=new int[s1.length()+1][s2.length()+1];
            for(int i=1;i<s1.length()+1;i++)
                for(int j=1;j<s2.length()+1;j++){
                    if(i==j)
                        continue;
                    if(s1.charAt(i-1)==s2.charAt(j-1))
                        dp[i][j]=dp[i-1][j-1]+1;
                    else
                        dp[i][j]=Integer.max(dp[i-1][j],dp[i][j-1]);
                    }
            System.out.println(Integer.max(dp[s1.length()][s2.length()-1],dp[s1.length()-1][s2.length()]));
        }
    } 
}