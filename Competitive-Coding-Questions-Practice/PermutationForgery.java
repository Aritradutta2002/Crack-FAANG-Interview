import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class PermutationForgery {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            for(int i=n-1;i>=0;i--)
                System.out.print(data[i]+" ");
            System.out.println();
        }
    } 
}
