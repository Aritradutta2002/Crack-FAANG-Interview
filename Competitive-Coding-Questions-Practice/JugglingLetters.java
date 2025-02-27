import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class JugglingLetters {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            int div=n;
            int[]vec=new int[26];
            while(n-->0){
                String s=r.readLine().trim();
                int size=s.length();
                for(int i=0;i<size;i++)
                    vec[s.charAt(i)%26]++;
            }
            boolean check=true;
            for(int i:vec)
                if(i% div!=0){
                    check=false;
                    break;
                }
            if(check)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    } 
}