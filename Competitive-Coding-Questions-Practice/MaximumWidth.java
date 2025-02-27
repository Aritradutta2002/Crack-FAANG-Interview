import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaximumWidth {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(t.nextToken());
        int m = Integer.parseInt(t.nextToken());
        String s = r.readLine().trim();
        String k = r.readLine().trim();
        int[]min = new int[26];
        int[]max = new int[26];
        Arrays.fill(min, -1);
        Arrays.fill(max, -1);
        for(int i = 0;i < n; i ++){
            char c = s.charAt(i);
            if(min[c - 'a'] == -1)
                min[c - 'a'] = i;
            
            max[c - 'a'] = i;
        }
        int ans = 0;
        for(int i = 1; i < m; i ++){
            ans = Math.max(ans, max[k.charAt(i) - 'a'] - min[k.charAt(i - 1) - 'a']);
        }

        System.out.println(ans);

        
    }
        
}
