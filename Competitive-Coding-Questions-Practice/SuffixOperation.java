import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SuffixOperation {
    static long getCount(int[]array, int n){
        long count = 0;
        for(int i = 1; i < n; i++)
            count += Math.abs(array[i - 1] - array[i]);
        return count;
    }
    static long getChange(int[]array, int pos, int n){
        if(pos == 0)
            return -Math.abs(array[0] - array[1]);
        else if(pos == n - 1)
            return -Math.abs(array[n - 1] - array[n - 2]);
        else {
            long diff = Math.abs(array[pos - 1] - array[ pos + 1]) -Math.abs(array[pos] - array[pos + 1])- Math.abs(array[pos] - array[pos - 1]);
            return diff;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n; i ++)
                array[i] = Integer.parseInt(t.nextToken());

            long current = getCount(array, n);

            long min = Long.MAX_VALUE;
            for(int i = 0; i < n; i ++){
                min = Math.min(min, getChange(array, i, n));
                // System.out.println(i +" "+ getChange(array, i, n) );
            }
            // System.out.println(current + " " + min);
            System.out.println(current + Math.min(min, 0));
        }
    }
        
}
