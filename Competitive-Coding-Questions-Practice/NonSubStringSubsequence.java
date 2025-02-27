import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NonSubStringSubsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int y = Integer.parseInt(r.readLine());
        while(y-->0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int q = Integer.parseInt(t.nextToken());
            String s=r.readLine();
            while(q-->0){
                t = new StringTokenizer(r.readLine());
                int start = Integer.parseInt(t.nextToken())-1;
                int end = Integer.parseInt(t.nextToken())-1;
                boolean c1 = false, c2 = false;
                for(int i = start -1 ; i >= 0 ; i--)
                    if(s.charAt(i) == s.charAt(start))
                        c1=true;
                for(int i = end + 1 ; i < n ; i++)
                    if(s.charAt(i) == s.charAt(end))
                        c2=true;
                if(c1||c2)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
        
}
