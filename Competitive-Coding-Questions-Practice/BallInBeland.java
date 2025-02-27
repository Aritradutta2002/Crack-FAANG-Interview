import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BallInBeland {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int x = Integer.parseInt(t.nextToken());
            int y = Integer.parseInt(t.nextToken());
            int n = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            StringTokenizer t2 = new StringTokenizer(r.readLine());
            HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
            for(int i = 0 ; i < n ; i++){
                int a = Integer.parseInt(t.nextToken());
                int b = Integer.parseInt(t2.nextToken());
                if(map.containsKey(a))
                    map.get(a).add(b);
                else{
                    map.put(a, new ArrayList<>());
                    map.get(a).add(b);
                }
            }

            int[]count = new int[y + 1];
            int sum = 0;
            long c = 0;

            TreeSet<Integer>keys = new TreeSet<>(map.keySet());

            for(int key : keys){
                ArrayList<Integer>list = map.get(key);
                int temp = 0;
                for(int i : list){
                    c += sum - count[i];
                    count[i] ++;
                    temp++;
                }
                sum+=temp;
            }

            System.out.println(c);


        }
    }
        
}
