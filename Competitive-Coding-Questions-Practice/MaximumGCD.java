import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MaximumGCD {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            if(n%2!=0)
                n--;
            System.out.println(n/2);
        }
    } 
}