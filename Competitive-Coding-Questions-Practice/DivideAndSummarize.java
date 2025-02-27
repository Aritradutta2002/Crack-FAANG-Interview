import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class DivideAndSummarize {
    static HashSet<Long>set;
    static void check(int[]array, long[]sum, int start, int end){
        if(start >= end)
            return;
        set.add(sum[end] - sum[start]); 
        
        int mid = array[start] + (array[end - 1] - array[start]) / 2;

        int pos = Arrays.binarySearch(array, start, end, mid);
        pos = Math.max(Math.abs(pos) - 1, 0);

        while(pos + 100000 <= end)
            if(array[pos + 99999] <= mid)
                pos+=100000;
            else
                break;
            
        while(pos + 10000 <= end)
            if(array[pos + 9999] <= mid)
                pos+=10000;
            else
                break;
        while(pos + 1000 <= end)
            if(array[pos + 999] <= mid)
                pos+=1000;
            else
                break;
        while(pos + 100 <= end)
            if(array[pos + 99] <= mid)
                pos+=100;
            else
                break;
        while(pos + 10 <= end)
            if(array[pos + 9] <= mid)
                pos+=10;
            else
                break;
        while(pos + 1 <= end)
            if(array[pos] <= mid)
                pos+=1;
            else
                break;
        // System.out.println(pos);
        if(pos == end || pos == start)
            return;

        check(array, sum, start, pos);
        check(array, sum, pos, end);

    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int q = Integer.parseInt(t.nextToken());
            int[]array = new int[n];
            t = new StringTokenizer(r.readLine());
            for(int i = 0; i < n; i++)
                array[i] = Integer.parseInt(t.nextToken());
            long[]sum = new long[n + 1];
            Arrays.sort(array);
            for(int i = 1; i <= n; i++)
                sum[i] = sum[i - 1] + (long)array[i - 1];
            set = new HashSet<>();
            check(array, sum, 0, n);    
            while(q -- > 0){
                int s = Integer.parseInt(r.readLine());
                if(set.contains((long)s))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
        
}
