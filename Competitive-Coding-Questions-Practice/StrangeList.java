import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StrangeList {
    static long getSum(int n, int x, long current){
        long sum = current * n;
        sum += (n % x == 0) ? getSum(n / x, x, current * x) : 0;
        return sum;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int x = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            Queue <Integer> array = new LinkedList<>();
            Queue <Integer> count = new LinkedList<>();
            
            long sum = 0;

            for(int i = 0; i < n ; i++){
                int num = Integer.parseInt(t.nextToken());
                array.add(num);
                count.add(1);
                sum += num;
            }

            while(!array.isEmpty()){
                int poped = array.remove();
                int popedCount = count.remove();
                if(poped % x == 0){
                    sum += poped * popedCount;
                    array.add(poped / 2);
                    count.add(popedCount * x);
                } else 
                    break;
            }
            while(!array.isEmpty())
                sum +=array.remove() * count.remove();

            System.out.println(sum);

            
        }
    }
        
}
