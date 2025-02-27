import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Berpizza{
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        boolean[]array = new boolean[n + 5];
        int ptr = 0;
        Queue<Pair>q = new LinkedList<>();
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        StringBuilder b = new StringBuilder();
        while(n-- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int tt = Integer.parseInt(t.nextToken());
            if(tt == 1){
                array[ptr] = true;
                Pair np = new Pair(ptr++, Integer.parseInt(t.nextToken()));
                pq.add(np);
                q.add(np);
            }
            else if(tt == 2){
                Pair pop = q.remove();
                while(!array[pop.pos])
                    pop = q.remove();
                b.append(pop.pos + 1);
                b.append(" ");
                array[pop.pos] = false;
            }
            else{
                Pair pop = pq.remove();
                while(!array[pop.pos])
                    pop = pq.remove();
                b.append(pop.pos + 1);
                array[pop.pos] = false;
                b.append(" ");
            }
            
        }
        System.out.println(b);

    }
    
}
class Pair implements Comparable<Pair>{
    int pos, m;
    Pair(int pos, int m){
        this.pos = pos;
        this.m = m;
    }

    @Override
    public int compareTo(Pair o) {
        return o.m - m;
    }
}