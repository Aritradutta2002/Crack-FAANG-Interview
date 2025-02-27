import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSumarraySum {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        int[]array = new int[n];
        StringTokenizer t = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; i++)
            array[i] = Integer.parseInt(t.nextToken());
        long max = array[0], current = 0;

        for(int i : array){
            current = Math.max(i, current + i);
            max = Math.max(current, max);
        }

        System.out.println(max);
    }
    
}
