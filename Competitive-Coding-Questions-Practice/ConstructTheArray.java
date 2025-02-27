import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ConstructTheArray {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        while(t -- > 0){
            int n = Integer.parseInt(r.readLine());
            PriorityQueue <Indexes>queue = new PriorityQueue<>(new compp());
            queue.add(new Indexes(0, n));
            int[]sol = new int[n];
            int current = 1;
            for(int i = n; i > 0; i --){
                Indexes now = queue.remove();
                int left = now.left, right = now.right;
                int mid = left + (right - left) / 2 - (1 - (right - left) % 2);
                sol[mid] = current ++;
                if(left < mid)
                    queue.add(new Indexes(left, mid));
                if(right > mid + 1)
                    queue.add(new Indexes(mid + 1, right));
                 
            }
            StringBuilder b = new StringBuilder();
            for(int i :sol){
                b.append(i);
                b.append(" ");
            }
            System.out.println(b);
        }
    }
        
}
class compp implements Comparator<Indexes>{

    @Override
    public int compare(Indexes n1, Indexes n2) {
        if(n1.right - n1.left !=n2.right - n2.left)
            return Integer.compare(n2.right - n2.left,n1.right - n1.left);
        return Integer.compare(n1.left, n2.left);
    }

}
class Indexes{
    int left, right;

    Indexes(int left, int right){
        this.left = left;
        this.right = right;
    }

}
