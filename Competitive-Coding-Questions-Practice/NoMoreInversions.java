import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NoMoreInversions {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int k = Integer.parseInt(t.nextToken());

            int[]array = new int[k];
            for(int i = 0; i < k ;i ++)
                array[i] = i + 1;

            int p1 = 2 * k - n - 1;
            int p2 = k - 1;
            while(p1 <= p2){
                int temp = array[p1];
                array[p1] = array[p2];
                array[p2] = temp;
                p1 ++;
                p2 --;
            }
            StringBuilder b = new StringBuilder();
            for(int i : array){
                b.append(i);
                b.append(" ");
            }
            System.out.println(b);

        }
    }
        
}
