import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CancelTheTrain {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int m = Integer.parseInt(t.nextToken());
            int[]a = new int[n];
            int []b = new int[m];
            t =new StringTokenizer(r.readLine());
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            for(int j = 0; j < m; j++)
                b[j] = Integer.parseInt(t.nextToken());
            int p1 = 0, p2 = 0, c = 0;
            while(p1 < n && p2 < m){
                if(a[p1] == b[p2]){
                    c++;
                    p1++;
                    p2++;
                }
                else if(a[p1] > b[p2])
                    p2++;
                else
                    p1++;
            }
            System.out.println(c);
        }
    }
        
}
