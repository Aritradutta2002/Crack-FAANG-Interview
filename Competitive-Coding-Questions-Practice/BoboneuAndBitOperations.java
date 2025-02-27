import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BoboneuAndBitOperations {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(t.nextToken());
        int m = Integer.parseInt(t.nextToken());
        int[]a = new int [n];
        int[]b = new int [m];
        t = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(t.nextToken());
        t = new StringTokenizer(r.readLine());
        for(int i = 0; i < m; i++)
            b[i] = Integer.parseInt(t.nextToken());

        for(int i = 0; i < Math.pow(2, 9); i ++){
            boolean found = true;
            for(int j : a){
                boolean found1 = false;
                for(int k : b){
                    if(((j & k) | i ) == i){
                        found1 = true;
                    }
                }
                found = found && found1;
                
            }
            if(found){
                System.out.println(i);
                break;
            }
        }
    }
        
}
