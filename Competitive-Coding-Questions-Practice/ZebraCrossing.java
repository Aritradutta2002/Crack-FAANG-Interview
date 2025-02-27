import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ZebraCrossing {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int k = Integer.parseInt(t.nextToken());
            String s = r.readLine().trim();
            int [] cnt = new int[n];
            for(int i = 1; i < n; i ++)
                if(s.charAt(i) == s.charAt(i - 1))
                    cnt[i] = cnt[i - 1];
                else
                    cnt[i] = cnt[i - 1] + 1;
            int ans = -1;
            for (int i = 0; i < n; i++)
                if(k <= cnt[i] && k % 2 == cnt[i] % 2)
                    ans = Integer.max(ans, i + 1);
            System.out.println(ans);

        }
    }
        
}
