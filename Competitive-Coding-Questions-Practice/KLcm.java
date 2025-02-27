import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KLcm {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            long n = Integer.parseInt(t.nextToken());
            int k = Integer.parseInt(t.nextToken());
            
            Queue<Long>queue = new LinkedList<>();
            while(k!=3){
                queue.add(1L);
                n--;
                k--;
            }
            long div = n / 2;
            long num = 1;
            while(div % num == 0)
                num *= 2;
            
            
            if(n % 2 == 1){
                queue.add(div);
                queue.add(div);
                queue.add(1L);
                
            } else {
                long change = (num) / 2;
                if(change == div)
                    change /= 2;
                queue.add(div - change);
                queue.add(div - change);
                queue.add(n - (div - change)  *  2);
                }
            for(long i : queue)
                System.out.print(i + " ");
            System.out.println();


        }
    }
        
}
