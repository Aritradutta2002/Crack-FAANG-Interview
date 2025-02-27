import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FactoryMachines {
    static boolean isPossible(long time, int[]array, int n, int x){
        long count = 0;
        for(int i : array)
            count += time / i;
        if(count < 0)
            count = Long.MAX_VALUE;
        return count >= x;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(t.nextToken());
        int x = Integer.parseInt(t.nextToken());
        int[]array = new int[n];
        t = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; i++)
            array[i] = Integer.parseInt(t.nextToken());
        
        long start = 0;
        long end = Long.MAX_VALUE;
        long ans = end;
        while(start <= end){
            long mid = start + (end - start) / 2;
            if(isPossible(mid, array, n, x)){
                ans = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }

        System.out.println(ans);
    }
        
}
