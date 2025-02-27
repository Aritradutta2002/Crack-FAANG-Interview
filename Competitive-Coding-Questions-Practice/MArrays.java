import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MArrays {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int k = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n; i ++)
                array[i] = Integer.parseInt(t.nextToken());
            HashMap<Integer, Integer>set = new HashMap<>();
            for(int  i = 0; i < n; i ++){
                int num = array[i] % k;
                if(set.containsKey(num))
                    set.replace(num, set.get(num) + 1);
                else 
                    set.put(num, 1);
            }
            int ans = 0;
            HashSet<Integer>visited = new HashSet<>();
            for(int key : set.keySet()){
                int key2 = k - key;
                if(visited.contains(key))
                    continue;
                if(key == 0)
                    continue;
                if(set.containsKey(key2)){
                    visited.add(key2);
                    ans ++;
                    int n1 = set.get(key) , n2 = set.get(key2);
                    ans += Math.max(Math.max(n1, n2) - Math.min(n1, n2) - 1, 0);
                    
                } 
                else if(key * 2 == k){
                    ans++;
                }
                else {
                    ans += set.get(key);
                }
                // System.out.println(key + " " + ans);
            }
            if(set.containsKey(0))  
                ans++;
            System.out.println(ans);
            
        }
    }
        
}
