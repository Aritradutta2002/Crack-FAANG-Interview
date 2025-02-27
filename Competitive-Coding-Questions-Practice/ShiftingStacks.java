import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * ShiftingStacks
 */
public class ShiftingStacks {

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n;i ++)
                array[i] = Integer.parseInt(t.nextToken());
            long s = 0;
            boolean check = true;
            // long l = 0;
            for(int i = 0; i < n; i++){
                s += array[i];
                if(s < i)
                    check = false;
                else
                    s-=i;
            }
            if(check)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    
}