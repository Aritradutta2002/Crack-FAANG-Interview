import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NapoleanCake {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n ;i ++)
                array[i] = Integer.parseInt(t.nextToken());

            int[]ans = new int[n];
            int []start = new int[n], end = new int[n];
            int c = 0;

            for(int i = 0; i < n; i++){
                if(array[i] != 0){
                    end[i]++;
                    start[Math.max(0, i - array[i] + 1)]++;
                }
            }

            for(int i = 0; i < n ; i++){
                c += start[i];
                if( c > 0)
                    ans[i] = 1;
                c -= end[i];
            }

            StringBuilder b = new StringBuilder();
            for(int i : ans){
                b.append(i);
                b.append(" ");
            }
            System.out.println(b);
        }
    }
        
}
