import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.StringTokenizer;

 class XorInequality {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        long mod = 1000000000L + 7L;
        int N = 100000 + 10;
        long[]arr = new long[N];
        arr[0] = 1;
        for(int i = 1; i < N; i ++)
            arr[i] = ((long)arr[i - 1] * 2L) % (long)mod;
            
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            System.out.println((arr[n - 1]));
        }
    }
        
}
