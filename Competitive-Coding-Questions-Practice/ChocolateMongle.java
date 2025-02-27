import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class ChocolateMongle {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int x = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            HashSet<Integer>set = new HashSet<>();
            for(int i = 0; i < n; i ++)
                set.add(Integer.parseInt(t.nextToken()));
            System.out.println(Math.min(n - x, set.size()));
        }
    }
        
}
