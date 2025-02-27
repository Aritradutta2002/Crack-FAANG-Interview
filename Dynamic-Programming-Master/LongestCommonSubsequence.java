import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class LongestCommonSubsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            int m=Integer.parseInt(data[0]);
            int n=Integer.parseInt(data[1]);
            String s1=r.readLine();
            String s2=r.readLine();
            int[][]memory=new int [m+1][n+1];
            for(int i=1;i<=m;i++)
                for(int j=1;j<=n;j++)
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        memory[i][j]=memory[i-1][j-1]+1;
                    }
                    else
                        memory[i][j]=Math.max(Math.max(memory[i-1][j-1],memory[i][j-1]),Math.max(memory[i-1][j-1],memory[i-1][j]));
            System.out.println(memory[m][n]);
        } 
    } 
}