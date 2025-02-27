import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AGAGAXOOORRR {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n; i ++)
                array[i] = Integer.parseInt(t.nextToken());
            
            int[]preffix = new int[n + 1];
            int[]suffix = new int[n + 1];
            for(int i = 1; i <= n; i ++)
                preffix[i] = preffix[i - 1] ^ array[i - 1];
            for(int i = n - 1; i >= 0; i --)
                suffix[i] = suffix[i + 1] ^ array[i];
            
            boolean pos = false;

            for(int i = 0; i < n; i ++){
                int n1 = preffix[ i + 1];
                int curr = 0;
                for(int j = i + 1; j < n; j ++){
                    curr ^= array[j];
                    int n2 = suffix[j + 1];
                    if(n1 == n2 && n1 == curr){
                        pos = true;
                        
                    }
                }
            }
            // for(int i : preffix)
            //     System.out.print((i + " "));
            // System.out.println();
            // for(int i : suffix)
            //     System.out.print((i + " "));
            // System.out.println();

            for(int i = 1; i < n; i ++){
                if(preffix[i] == suffix[i]){
                    // System.out.println(preffix[i] + " " + suffix[i]);
                    pos = true;
                    // System.out.println(i + "!!!!!!!!!!!!");
                }
            }

            String s = (pos) ? "YES" : "NO";
            System.out.println(s);

        }
    }
        
}
