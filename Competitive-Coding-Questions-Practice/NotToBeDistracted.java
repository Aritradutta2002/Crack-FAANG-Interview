import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.StringTokenizer;

public class NotToBeDistracted {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            String s = r.readLine();
            boolean[]v = new boolean [29];
            boolean c = true;
            for (int i = 0; i < n; i++ ){
                if(v[s.charAt(i) % 26])
                    c = false;
                v[s.charAt(i) % 26] = true;
                // System.out.println(s.charAt(i));
                int ptr = i;
                for(ptr = i; ptr < n; ptr++){
                    if(s.charAt(ptr)!= s.charAt(i))
                        break;
                }
                i = ptr - 1;
            }

            if(c)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
        
}
