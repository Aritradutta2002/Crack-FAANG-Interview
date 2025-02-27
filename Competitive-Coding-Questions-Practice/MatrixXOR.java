import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 class MatrixXOR {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(reader.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(reader.readLine());
            long n = Long.parseLong(t.nextToken());
            long m = Long.parseLong(t.nextToken());
            long k = Long.parseLong(t.nextToken());
            long r = 1, s = 2;
            long ans = 0;
            if(m < n){
                long te = m;
                m = n; 
                n = te;
            }
            for(long i = 0; i < m; i ++){
                if(r % 2== 1)
                    ans = ans ^ (s + k);
                s++;
                r = Math.min(n, r + 1);
                // System.out.println(ans);
            }
            r--;
            while(r > 0){
                // System.out.println(ans);
                if(r % 2 == 1)
                    ans = ans ^ (s + k);
                s++;
                r--;
            }

            System.out.println(ans);
        }
    }
        
}
