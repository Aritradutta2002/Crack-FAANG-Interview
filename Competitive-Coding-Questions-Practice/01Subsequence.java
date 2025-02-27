import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Subsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]z = new int[n / 2 + n % 2], o = new int[n / 2];
            int zc = 0, oc = 0;
            for(int i = 0; i < n; i ++)
                if(i % 2 == 0)
                    z[zc++] = Integer.parseInt(t.nextToken());
                else
                o[oc++] = Integer.parseInt(t.nextToken());
            Arrays.sort(z);
            Arrays.sort(o);
            zc = z.length - 1;
            oc = 0;
            long s = 0;
            int[]fin = new int[n];
            for (int i = 0; i < n; i ++)
                if (i % 2 == 0)
                    fin[i] = z[zc--];
                else{
                    s += o[oc];
                    fin[i] = o[oc++];
                }
            long ans = 0;
            StringBuilder b = new StringBuilder();
            for (int i : fin)
                b.append(i + " ");
            System.out.println(b);

            for(int i = 0; i < n; i ++)
                if(i % 2 == 1)
                    s -= fin[i];
                else
                    ans += (long)fin[i] * s;
            System.out.println(ans);
            
                
        }
    }
        
}
