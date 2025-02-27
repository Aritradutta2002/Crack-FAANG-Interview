import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubstring {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            int m=Integer.parseInt(data[0]);
            int n=Integer.parseInt(data[1]);
            String s1=r.readLine();
            String s2=r.readLine();
            int[][]memory=new int[m][n];
            for(int i=0;i<m;i++)
                if(s1.charAt(i)==s2.charAt(0))
                    memory[i][0]=1;
            for(int i=0;i<n;i++)
                if(s2.charAt(i)==s1.charAt(0))
                    memory[0][i]=1;
            for(int i=1;i<m;i++)
                for(int j=1;j<n;j++)
                    if(s1.charAt(i)==s2.charAt(j))
                        memory[i][j]=memory[i-1][j-1]+1;
                
            int max=0;
            for(int i=0;i<m;i++)
                for(int j=0;j<n;j++)
                    max=Math.max(memory[i][j], max);
            System.out.println(max);
        } 
    } 
}