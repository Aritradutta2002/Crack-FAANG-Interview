import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SpyDetected {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[102];
            int[]aa = new int[n];
            for(int i = 0; i < n; i++){
                aa[i] = Integer.parseInt(t.nextToken());
                array[aa[i]]++;
            }
                
            int ans = 0;
            for(int i = 0; i < 102; i ++)
                if(array[i] == 1)
                    ans = i;


            for(int i = 0; i < n ; i++)
                if(aa[i] == ans)
                    System.out.println((i + 1));
        }
    }
        
}
