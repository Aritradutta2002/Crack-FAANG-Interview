import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DominosOnWindowSill {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int k1 = Integer.parseInt(t.nextToken());
            int k2 = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            int w = Integer.parseInt(t.nextToken());
            int b = Integer.parseInt(t.nextToken());
            int wa = Math.min(k1, k2) + Math.abs(k1 - k2) / 2;
            k1 = n - k1;
            k2 = n - k2;
            int ba = Math.min(k1, k2) + Math.abs(k1 - k2) / 2;
            if(b > ba || w > wa)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
        
}
