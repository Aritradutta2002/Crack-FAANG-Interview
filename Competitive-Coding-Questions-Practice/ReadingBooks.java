import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReadingBooks {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        StringTokenizer t = new StringTokenizer(r.readLine());
        int[]array = new int[n];
        for(int i = 0; i < n; i++)
            array[i] = Integer.parseInt(t.nextToken());
        long sum = 0;
        long max = 0;
        for(int i : array){
            sum += i;
            max = Math.max(max, i);
        }
        System.out.println(Math.max(sum, max*2));
    }
        
}
