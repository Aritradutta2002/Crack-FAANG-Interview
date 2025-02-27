import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BorringAppartments {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String s=r.readLine().trim();
            int digit=Integer.parseInt(Character.toString(s.charAt(0)));
            long sum=10*(digit-1);
            long n1=s.length();
            long n2=n1+1;
            long n=n1*n2;
            sum+=n/2;
            System.out.println(sum);
        }
    } 
}
