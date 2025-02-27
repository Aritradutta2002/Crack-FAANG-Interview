import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class StringSimilarity {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String s=r.readLine();
            n=s.length();
            StringBuilder b=new StringBuilder();
            for(int i=0;i<n;i+=2)
                b.append(s.charAt(i));
            System.out.println(b.toString());
        }
    } 
}