import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BoxFitting {
    public static int log2(int N)
    {
  
        // calculate log2 N indirectly
        // using log() method
        int result = (int)(Math.log(N) / Math.log(2));
  
        return result;
    }
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
            int[]c = new int [35];  
            
            for(int i :array)
                c[log2(i)]++;
            int to = 0;
            int ans = 0;
            while(to < n){
                int curr = k;
                for(int i = 35; i >= 0; i --){
                    if(Math.pow(2, i) <= curr && c[i] > 0){
                        c[i]--;
                        curr -= Math.pow(2, i);
                        to++;
                        i++;
                    }
                }
                ans++;
            }
            System.out.println(ans);
            
            
        }
    }
        
}
