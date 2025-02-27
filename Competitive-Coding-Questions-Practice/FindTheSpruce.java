import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindTheSpruce {
    
    static boolean getCount(int n, int m, char[][]array, int start, int end, int i, int j){
        
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int m = Integer.parseInt(t.nextToken());
            char[][]array = new char[n][m];
            for(int i = 0 ;i < n ; i ++){
                String s = r.readLine().trim();
                for(int j = 0; i < n ;j ++)
                    array[i][j] = s.charAt(j);
            }
        }

    }       
}
