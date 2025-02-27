import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class asdas {
    static long getClosest(long n){
        long ans = 1;
        while(ans * 2 <= n)
            ans *= 2;
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            long n = Long.parseLong(r.readLine());
            long closest = getClosest(n);
            StringBuilder b = new StringBuilder();
            for(long i = closest + 1; i <= n; i ++){
                b.append(i);
                b.append(" ");
            }
            for(long i = 1; i <= closest; i++){
                b.append(i);
                b.append(" ");
            }
            System.out.println(b);
        }
    }
        
}
