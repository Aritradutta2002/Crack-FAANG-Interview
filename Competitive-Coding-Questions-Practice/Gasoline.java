import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

 class Gasoline {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1-- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            StringTokenizer t2 = new StringTokenizer(r.readLine());
            Pos[]array = new Pos[n];   
            for(int i = 0; i < n; i ++)
                array[i] = new Pos(Integer.parseInt(t.nextToken()), Integer.parseInt(t2.nextToken()));
            
            Arrays.sort(array, new Comparator<Pos>(){

                @Override
                public int compare(Pos o1, Pos o2) {
                    return Integer.compare(o1.cost, o2.cost);
                }
                
            });

            int count = 0;
            long cost = 0;

            for(Pos i : array){
                int pick = Math.min(i.count, n - count);
                cost += (long)i.cost * (long)pick;
                count += pick;
            }

            System.out.println(cost);

            
            
        }
    }

      
}
class Pos{
    int count, cost;
    Pos(int count, int cost){
        this.cost = cost;
        this.count = count;
    }
}
  
