import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * PheonixAndSocks
 */
public class PheonixAndSocks {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int n1 = Integer.parseInt(t.nextToken());
            int n2 = Integer.parseInt(t.nextToken());

            t = new StringTokenizer(r.readLine());
            int N = 100000 * 2+ 100;
            int[]a = new int[N];
            int[]b = new int[N];
            HashSet<Integer>set = new HashSet<>();
            for(int i = 0; i < n1; i ++){
                int num = Integer.parseInt(t.nextToken());
                a[num]++;
                set.add(num);
            }
            for(int i = 0; i < n2; i ++){
                int num = Integer.parseInt(t.nextToken());
                b[num]++;
                set.add(num);
            }
            int at = 0, bt = 0, ae = 0, be = 0;
            for(int i : set){
                int diff = Math.min(a[i], b[i]);
                a[i] -= diff;
                b[i] -= diff;

                at += a[i];
                bt+= b[i];
                ae += a[i] - a[i] % 2;
                be += b[i] - b[i] % 2;
            }
            if(at < bt){
                int temp = at;
                at = bt;
                bt = temp;
                temp = ae;
                ae = be;
                be = temp;
            }
            int sum = bt;
            sum += Math.max((at - bt - ae), 0);
            sum += Math.min(ae, at - bt) / 2;
            // System.out.println(Math.max((at - bt - ae), 0));
            // System.out.println(Math.min(ae, at - bt) / 2);
            System.out.println(sum);



        }
    }
    
    
}