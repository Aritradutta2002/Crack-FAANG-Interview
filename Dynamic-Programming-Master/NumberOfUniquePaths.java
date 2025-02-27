import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class NumberOfUniquePaths {
    static int getPaths(int m,int n){
        int[][]memory=new int[m][n];
        for(int i=0;i<m;i++)
            memory[i][0]=1;
        for(int i=0;i<n;i++)
            memory[0][i]=1;
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                memory[i][j]=memory[i-1][j]+memory[i][j-1];
        return memory[m-1][n-1];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
         int t=Integer.parseInt(r.readLine());
         while(t-->0){
             String[]data=r.readLine().split(" ");
             System.out.println(getPaths(Integer.parseInt(data[0]),Integer.parseInt(data[1])));
         }
    } 
}