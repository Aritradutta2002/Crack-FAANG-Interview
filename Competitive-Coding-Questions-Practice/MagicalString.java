import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicalString {
    public static void main(String[] args)throws IOException {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            if(n%2==1)
                System.out.println(n/2+1);
            else
                System.out.println(n/2);
        }
    }
}