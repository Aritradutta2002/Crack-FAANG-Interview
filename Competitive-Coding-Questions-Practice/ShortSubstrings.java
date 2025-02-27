import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ShortSubstrings {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String s=r.readLine().trim();
            StringBuilder b=new StringBuilder();
            b.append(s.charAt(0));
            int n=s.length();
            for(int i=1;i<n-1;i+=2)
                b.append(s.charAt(i));
            b.append(s.charAt(n-1));
            System.out.println(b.toString());

        }
    } 
}
