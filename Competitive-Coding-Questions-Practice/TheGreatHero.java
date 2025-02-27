import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheGreatHero {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            long ah = Integer.parseInt(t.nextToken());
            long bh = Integer.parseInt(t.nextToken());
            int n = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            long[]a = new long[n], b = new long[n];
            for(int i = 0; i < n ; i++)
                a[i] = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            for(int i = 0; i < n ; i++)
                b[i] = Integer.parseInt(t.nextToken());
            long max = Integer.MIN_VALUE;
            int maxPos = 0;
            for(int i = 0; i < n; i++)
                if(a[i] > max){
                    max = a[i];
                    maxPos = i;
                }
            for(int i = 0; i < n ;i ++){
                if(
                    i == maxPos
                ) continue;
                long attacks = b[i] / ah;
                attacks += (b[i] % ah == 0) ? 0 : 1;
                bh -= a[i] * attacks;
            }

            long attacks = b[maxPos] / ah;
            attacks += (b[maxPos] % ah == 0) ? 0 : 1;
            attacks --;
            bh -= a[maxPos] * attacks;

            if(bh > 0)
                System.out.println("YES");
            else
                System.out.println("NO");
            
        }
    }
        
}
