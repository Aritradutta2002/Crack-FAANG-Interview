import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CircleOfMonsters{
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        OutputStream outputStream =System.out;
        PrintWriter out =new PrintWriter(outputStream);
            
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            long[]a = new long[n];
            long[]b = new long[n];
            for(int i = 0; i < n; i ++){
                StringTokenizer t = new StringTokenizer(r.readLine());
                a[i] = Long.parseLong(t.nextToken());
                b[i] = Long.parseLong(t.nextToken());
            }

            long ans = 0;
            for(int i = 0; i < n; i++){
                int next = (i + 1) % n;
                ans += a[i];
                ans -= Math.min(b[i], a[next]);
            }

            long min = Long.MAX_VALUE ;
            for(int i = 0; i < n; i++){
                int next = (i + 1) % n;
                long diff = Math.min(b[i], a[next]);
                min = Math.min(min, diff);
            }
            out.println(ans + min);

            
           
        }
        out.close(); 
        
    }
    
}