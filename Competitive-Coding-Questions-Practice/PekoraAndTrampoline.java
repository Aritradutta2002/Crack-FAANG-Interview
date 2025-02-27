import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PekoraAndTrampoline {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            long[]extras = new long[n + 1];

            for(int i = 0; i < n ;i ++)
                array[i] = Integer.parseInt(t.nextToken());

            long s = 0;

            for(int i = 0; i < n; i ++){
                int diff = array[i] - 1;
                // System.out.println(diff+" !!!!!!!!!!!!!!!!!!!!!!!!!!!1");
                for(int j = i + 2; j < n && diff > 0; j ++){
                    if(extras[i] > 0)
                        extras[i] --;
                    else
                        s++;
                    extras[j]++;
                    diff--;
                }
                // for(long l : extras){
                //     System.out.print(l + " ");
                // }
                // System.out.println();
                // System.out.println(s);
                if(diff > 0){
                    if(diff >= extras[i]){
                        diff -= extras[i];
                        extras[i] = 0;
                    } else {
                        extras[i] -= diff;
                        diff = 0;
                    }
                }
                
                s += diff;
                extras[i + 1] += extras[i];
                // for(long l : extras){
                //     System.out.print(l + " ");
                // }
                // System.out.println();
                // System.out.println(s);
            }
            System.out.println(s);
            
        }
    }
        
}
