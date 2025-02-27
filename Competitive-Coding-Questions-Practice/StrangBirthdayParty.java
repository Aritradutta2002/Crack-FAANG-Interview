import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StrangBirthdayParty {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int m = Integer.parseInt(t.nextToken());
            Integer[]a = new Integer[n];
            Integer[]b = new Integer[m];
            t = new StringTokenizer(r.readLine());
            for(int  i = 0; i < n ;i ++)
                a[i] = Integer.parseInt(t.nextToken());
            t= new StringTokenizer(r.readLine());
            for(int i = 0; i < m ;i ++)
                b[i] = Integer.parseInt(t.nextToken());

            Arrays.sort(a);
            long sum = 0;
            int ptr = 0;
            for(int i = n - 1; i >= 0; i--)
                if(b[ptr] < b[a[i] - 1])
                    sum += b[ptr++];
                else
                    sum += b[a[i] - 1];
            System.out.println(sum);

        }
    }
        
}
