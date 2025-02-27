import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SumOfThreeValues {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(t.nextToken());
        int x = Integer.parseInt(t.nextToken());
        t = new StringTokenizer(r.readLine());
        int[]array = new int[n];
        for(int i = 0; i < n; i++)
            array[i] = Integer.parseInt(t.nextToken());
        
        boolean found = false;
        for(int i = 0; i < n; i++){
            HashMap <Integer, Integer> map = new HashMap<>();
            

            for(int j = 0; j < n; j++){
                if(j == i)
                    continue;
                map.put(array[j], j);
            }

            int target = x - array[i];
            for(int  j = 0; j < n; j++){
                if(j==i)
                    continue;
                if(map.containsKey(target - array[j]))
                    if(map.get(target - array[j]) != j){
                        System.out.println((i+1)+" "+(j+1)+" "+(map.get(target - array[j])+1));
                        found = true;
                        break;
                    }
            }
            if(found)
                break;      
        }
        if(!found)
            System.out.println("IMPOSSIBLE");

    }
        
}
