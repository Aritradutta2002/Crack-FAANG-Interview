import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class NumberOfStringsUsingabc {
    static int[][][]memory;
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            memory=new int[n+1][3][2];
            memory[1][0][0]=1;
            memory[1][1][0]=2;
            memory[1][2][0]=2;
            memory[1][0][1]=2;
            memory[1][1][1]=3;
            memory[1][2][1]=3;
            for(int i=2;i<n+1;i++)
                for(int j=0;j<3;j++)
                    for(int k=0;k<2;k++){
                        int count=0;
                        if(k>0)
                            count+=memory[i-1][j][k-1];
                        if(j>0)
                            count+=memory[i-1][j-1][k];
                        count+=memory[i-1][j][k];
                        memory[i][j][k]=count;
                    }
            System.out.println(memory[n][2][1]);

        } 
    } 
}