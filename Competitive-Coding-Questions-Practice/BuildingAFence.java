import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuildingAFence {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            long k = Integer.parseInt(t.nextToken());
            boolean p = true;
            t = new StringTokenizer(r.readLine());
            long[]array = new long[n];
            for(int i = 0; i < n; i ++)     
                array[i] = Integer.parseInt(t.nextToken());

            long min = array[0], max = array[0];
            for(int i = 1; i < n - 1; i ++){
                // System.out.println(max + " "+ min);
                min = min - k + 1;
                max = max + k - 1;
                if(max < array[i] || min > array[i] + k - 1){
                    p = false;
                    break;
                }
                max = Math.min(max, array[i] + k - 1);
                min = Math.max(min, array[i]);
            }
            min = min - k + 1;
            max = max + k - 1;
            // System.out.println(max + " " + min);
            if(array[n - 1] > max || array[n - 1] < min)
                p = false;
            if(p)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
        
}
