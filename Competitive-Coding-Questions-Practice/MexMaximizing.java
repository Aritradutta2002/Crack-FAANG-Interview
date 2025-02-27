import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MexMaximizing {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(t.nextToken());
        int x = Integer.parseInt(t.nextToken());
        int[]arr = new int[x];
        int pos = 0, mul = 0;
        for(int i = 0; i < n; i ++){
            int num = Integer.parseInt(r.readLine());
            arr[num % x] ++;
            while(arr[pos] > mul){
                pos++;
                if(pos == x){
                    pos = 0;
                    mul ++;
                }
            }
            System.out.println(((long)pos + (long)mul * (long)x));
            
        }
    }
        
}
