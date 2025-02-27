import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class HiringWorkers {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 --> 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int k = Integer.parseInt(t.nextToken());
            int x = Integer.parseInt(t.nextToken());
            int count = 1;
            Queue <Integer> queue = new LinkedList<>();
            queue.add(x);
            ArrayList<Integer>extra = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            set.add(x);
            while(count < k && !queue.isEmpty()){
                int num = queue.remove();
                int min1 = 1;
                int min2 = num;
                
                for(int i = 1; i <= Math.ceil(Math.sqrt(num)); i++){
                    
                    if(num % i == 0){
                        if(num / i != i && min1 + min2 > i + num / i && !set.contains(i) && !set.contains(num / i)){
                            min1 = i;
                            min2 = num / i;
                        }
                    }
                }
                if(Math.min(min1, min2) == 1){
                    extra.add(Math.max(min1, min2));
                    continue;
                }
                set.add(min1);
                set.add(min2);
                queue.add(Math.max(min1, min2));
                queue.add(Math.min(min1, min2));
                count++;
            }

            long sum = k - count;
            // System.out.println(queue);
            for(int i :queue)
                sum += i;
            for(int i:extra)
                sum += i;
            System.out.println(sum);
        }
    }
        
}
