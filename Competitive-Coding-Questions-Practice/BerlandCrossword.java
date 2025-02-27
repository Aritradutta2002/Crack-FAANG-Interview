import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BerlandCrossword {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(reader.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(t.nextToken());
            int u = Integer.parseInt(t.nextToken());
            int r = Integer.parseInt(t.nextToken());
            int d = Integer.parseInt(t.nextToken());
            int l = Integer.parseInt(t.nextToken());
            int exu = Math.max(0, u - n + 2); 
            int exd = Math.max(0, d - n + 2);
            int exl = Math.max(0, l - n + 2);
            int exr = Math.max(0, r - n + 2);

            if(exu == 2){
                r--;
                l--;
            } else if(exu == 1){
                if(r > l)
                    r--;
                else
                    l--;
            }

            if(exd == 2){
                r--;
                l--;
            } else if(exd == 1){
                if(r > l)
                    r--;
                else
                    l--;
            }

            if(exr == 2){
                u--;
                d--;
            } else if(exr == 1){
                if(u > d)
                    u--;
                else
                    d--;
            }

            if(exl == 2){
                u--;
                d--;
            } else if(exl == 1){
                if(u > d)
                    u--;
                else
                    d--;
            }

            if(u < 0 || d < 0 || r < 0 ||l < 0)
                System.out.println("NO");
            else
                System.out.println("YES");

        }
    }
        
}
