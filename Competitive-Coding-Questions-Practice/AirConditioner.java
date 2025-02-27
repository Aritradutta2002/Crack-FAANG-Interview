import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AirConditioner {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 --> 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            long start = Long.parseLong(t.nextToken());
            long min = start, max = start;
            int current = 0;
            boolean isPossible = true;
            
            while(n --> 0){
                // System.out.println(min + " " + max);
                t = new StringTokenizer(r.readLine());
                int time = Integer.parseInt(t.nextToken());
                int low = Integer.parseInt(t.nextToken());
                int high = Integer.parseInt(t.nextToken());
                
                if(time - current < Math.abs(low - max) 
                && time - current < Math.abs(min - high)
                &&(min > high || max < low)){
                    isPossible = false;
                }

                min -= time - current;
                max += time - current;
                max = Math.min(max, high);
			    min = Math.max(min, low);

                current = time;
            }
            if(isPossible)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
        
}
