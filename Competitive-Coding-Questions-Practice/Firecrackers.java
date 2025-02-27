import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Firecrackers {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int m = Integer.parseInt(t.nextToken());
            int a = Integer.parseInt(t.nextToken());
            int b = Integer.parseInt(t.nextToken());
            int diff = Math.abs(a - b) - 1;
            int time = (a < b) ? (diff + a - 1) : diff + n - a;
            int ptr = m - 1;
            int[]arr = new int[m];
            t = new StringTokenizer(r.readLine());
            for(int i = 0; i < m; i ++)
                arr[i] = Integer.parseInt(t.nextToken());
            Arrays.sort(arr);
            int c = 0;
            // System.out.println(diff + " "+time);
            while(ptr >= 0 && diff > 0){
                while(arr[ptr] > time){
                    ptr --;
                    if(ptr < 0)
                        break;
                }
                if(ptr >= 0)
                    c++;
                time --;
                ptr --;
                diff--;
            }
            System.out.println(c);
        }
    }
        
}
