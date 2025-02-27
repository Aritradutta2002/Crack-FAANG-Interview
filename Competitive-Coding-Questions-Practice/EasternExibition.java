import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class EasternExibition {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            long x = 0, y = 0;
            HashSet<Integer> xs = new HashSet<>(), ys = new HashSet<>();
            for(int i = 0; i < n; i ++){
                StringTokenizer t = new StringTokenizer(r.readLine());
                int a = Integer.parseInt(t.nextToken()), b = Integer.parseInt(t.nextToken());
                x += a; y += b;
                xs.add(a); ys.add(b);
            }
            double xa = (double)x / (double)n;
            double ya = (double)y / (double)n;
            int ax = 1, ay = 1;
            if(xa - Math.floor(xa) - 0.5 == 0)
                ax++;
            if(ya - Math.floor(ya) - 0.5 == 0)
                ay++;
            Integer[] xarr = new Integer[xs.size()];
            int c = 0;
            for(int i : xs)
                xarr[c++] = i;
            Integer[] yarr =new Integer[ys.size()];
            c = 0;
            for(int i : ys)
                yarr[c++] = i;
            if(xs.size() == 2 && ys.size() == 1)
                ax = Math.abs(xarr[0] - xarr[1] - 1);
            if(ys.size() == 2 && ys.size() == 1)
                ay = Math.abs(yarr[0] - yarr[1]);


            
            System.out.println((long)ax * (long)ay);
        }
    }
        
}
