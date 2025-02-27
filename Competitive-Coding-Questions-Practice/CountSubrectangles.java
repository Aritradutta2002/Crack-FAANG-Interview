import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountSubrectangles {
    static long[] getCount (int[]array, int n){
        long[]freq = new long[n+1];
        int i = 0;
        while(i < n){
            
            if(array[i] == 0){
                i++;
                continue;
            }
            int j = i + 1;
            while(j < n){
                if(array[j]==0)
                    break;
                // System.out.println(j);
                j++;
            }

            int diff = j - i;
            // System.out.println(diff+"!!!!!!!!!!1");
            for(int k = 1; k <=diff ;k++)
                freq[k] += diff - k + 1;
            i = j; 
        }
        // System.out.println("222");
        return freq;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(t.nextToken());
        int m = Integer.parseInt(t.nextToken());
        long target = Long.parseLong(t.nextToken());
        int []a = new int[n];
        int []b = new int[m];
        t = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(t.nextToken());
        t = new StringTokenizer(r.readLine());
        for(int i = 0; i < m; i++)
            b[i] = Integer.parseInt(t.nextToken());

        long[]afreq = getCount(a, n);
        long[]bfreq = getCount(b, m);

        long ans = 0;
        
        // for(long i:afreq)
        //     System.out.print(i+" ");
        // System.out.println();
        // for(long i:bfreq)
        //     System.out.print(i+" ");
        // System.out.println();
        for(int i = 1; i <= Math.sqrt(target); i++)
            if(target % i == 0){
                int j = (int)(target / i);
                if(i <= n && j <=m && i >= 0 && j >=0){
                    ans += afreq[i] * bfreq[j];
                }
                if(i ==j)
                    continue;
                if(i <= m && j <=n && i >= 0 && j >=0){
                    ans += afreq[j] * bfreq[i];
                }
            }
        System.out.println(ans);
        
    }
        
}
