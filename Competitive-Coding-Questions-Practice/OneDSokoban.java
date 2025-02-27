import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class OneDSokoban {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int m = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            int[]a = new int[n], b = new int[m];
            for(int i = 0;i < n; i++)
                a[i] = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            for(int i = 0;i < m; i++)
                b[i] = Integer.parseInt(t.nextToken());
            int max1 = 0, max2 = 0;
            int[]cnt = new int[n + 1];
            for(int i = 1; i <= n; i ++){
                if(Arrays.binarySearch(b, a[i - 1]) >= 0)
                    cnt[i] = cnt[i - 1] + 1;
                else
                    cnt[i] = cnt[i - 1];
            }
            for(int i = 0; i < m; i ++){
                int count;
                int ans = 0;
                if(b[i] < 0){
                    int p1 = Math.abs(Arrays.binarySearch(a, 0));
                    int p2 = Arrays.binarySearch(a, b[i]);
                    if(p2 < 0)
                        p2 = Math.abs(p2);
                    else
                        p2++;
                    count = p1 - p2;
                } else {
                    int p1 = Math.abs(Arrays.binarySearch(a, 0));
                    int p2 = Arrays.binarySearch(a, b[i]);
                    if(p2 < 0)
                        p2 = Math.abs(p2);
                    else
                        p2 += 2;
                    count = p2 - p1;
                }
                // System.out.println(count);

                if(b[i] < 0){
                    int end = b[i] - count + 1;
                    int pos = Arrays.binarySearch(a, end - 1);
                    if(pos < 0)
                        pos = Math.abs(pos) - 1;
                    if(pos + 1 >= 0 && pos + 1 <= n)
                        ans = cnt[pos + 1];
                    int p1 = i;
                    int p2 = Math.abs(Arrays.binarySearch(b, end))- 1;
                    // System.out.println(i + " " + (p1 - p2));
                    ans += p1 - p2;
                    // ans += (cnt[p2] + 1);
                    max1 = Math.max(ans, max1);
                    
                } else {
                    int end = b[i] + count - 1;
                    int p1 = i;
                    int p2 = Arrays.binarySearch(b, end);
                    int pos = Arrays.binarySearch(a, end + 1);
                    if(pos < 0)
                        pos = Math.abs(pos) - 1;
                    if(pos + 1 >= 0 && pos + 1 <= n)
                        ans = cnt[n] - cnt[pos + 1];
                    
                    if(p2 < 0)
                        p2 = Math.abs(p2) - 1;
                    else
                        p2 += 1;
                    ans += p2 - p1;
                    // ans += (cnt[n] - cnt[p2]);
                    max2 = Math.max(ans, max2);
                }

            }
            System.out.println((max2 + max1));
        }
    }
    
}
