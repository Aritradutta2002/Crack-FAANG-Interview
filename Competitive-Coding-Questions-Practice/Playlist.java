import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Playlist {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        int[]array = new int[n];
        StringTokenizer t = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; i++)
            array[i] = Integer.parseInt(t.nextToken());
        
        HashMap<Integer,Integer> map = new HashMap<>();

        int last = -1;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int num = array[i];
            if(map.containsKey(num)){
                last = Math.max(last, map.get(num));
                map.replace(num, i);
            } else 
                map.put(num, i);
            ans = Math.max(i - last, ans);
        }

        System.out.println(ans);
    }
        
}
