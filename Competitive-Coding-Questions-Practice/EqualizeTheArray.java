import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EqualizeTheArray {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            HashMap<Integer, Integer>map = new HashMap<>();
            for(int i = 0; i < n; i ++){
                int num = Integer.parseInt(t.nextToken());
                if(map.containsKey(num))
                    map.replace(num, map.get(num) + 1);
                else
                    map.put(num, 1);
            }
            ArrayList<Integer>list = new ArrayList<>();
            list.addAll(map.values());
            Collections.sort(list);
            int min = Integer.MAX_VALUE;
            int size = list.size();
            ArrayList<Integer>sum = new ArrayList<>();
            sum.add(0);
            for(int i = 0; i < size; i ++)
                sum.add(sum.get(i) + list.get(i));
            for(int i = 0; i < size; i++){
                int count = sum.get(i) + sum.get(size) - sum .get(i + 1) - (size - i - 1) * list.get(i);
                min = Math.min(min, count);  
            }
            System.out.println(min);
            
        }
    }
        
}
