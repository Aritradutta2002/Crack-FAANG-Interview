import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Palindromifier {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String s=r.readLine().trim();
        int n=s.length();
        System.out.println(3);
        System.out.println("R "+(n-1));
        System.out.println("L "+n);
        System.out.println("L "+2); 
    } 
}
