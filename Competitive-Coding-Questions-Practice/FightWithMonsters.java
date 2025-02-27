import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FightWithMonsters {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(t.nextToken());
        long a = Integer.parseInt(t.nextToken());
        long b = Integer.parseInt(t.nextToken());
        long k = Integer.parseInt(t.nextToken());
        long[]array = new long [n];
        t = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; i++)
            array[i] = Integer.parseInt(t.nextToken()) % (a + b);
        for(int i = 0; i < n; i++)
            if(array[i] == 0)
                array[i] = a + b;
        int count = 0;
        Arrays.sort(array);
        for(long i : array){
            long req = i / a;
            if(i % a == 0)
                req--;
            k -= req;
            
            if(k >= 0)
                count++;
        }

        System.out.println(count);
        
    }
        
}
