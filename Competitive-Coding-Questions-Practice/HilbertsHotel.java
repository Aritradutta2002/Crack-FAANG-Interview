import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class HilbertsHotel {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            long[]array = new long [n];
            for(int i = 0; i < n; i++)
                array[i] = Long.parseLong(t.nextToken());

            for(int i = 0; i < n; i++){
                long ans = array[i] + i;
                ans = (ans % n + n) % n;
                array[i] = ans;
            }
            HashSet<Long> set = new HashSet<>();
            boolean found = false;
            for(long i :array)
                if(set.contains(i)){
                    found = true;
                    break;
                }
                else
                    set.add(i % n);

            if(found)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
        
}
