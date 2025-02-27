import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programe {
    class MaxMin{
        int max, min;
        MaxMin(int max, int min){
            this.max = max;
            this.min = min;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n =Integer.parseInt(t.nextToken());
            int q = Integer.parseInt(t.nextToken());
            int[]array = new int [n + 1];
            String s = r.readLine().trim();
            if(s.charAt(0) == '-')
                array[0] = -1;
            else
                array[0] = 1;

            for(int i = 1; i < n; i ++)
                if(s.charAt(i) == '-')
                    array[i] = array[i - 1] - 1;
                else
                    array[i] = array[i - 1] + 1;

            MaxMin[]ahead = new MaxMin[n];

            
            
        }
    }
        
}
