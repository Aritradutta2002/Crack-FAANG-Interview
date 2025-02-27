import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NastiaAndGoodArray {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n; i ++)
                array[i] = Integer.parseInt(t.nextToken());
            int min = Integer.MAX_VALUE;
            int minPos = 0;
            for(int i = 0; i < n; i ++)
                if(array[i] < min){
                    minPos = i;
                    min = array[i];
                }
            System.out.println((n - 1));
            for(int i = minPos % 2; i < n; i += 2){
                if(i == minPos)
                    continue;
                System.out.println((minPos + 1) + " " + (i + 1) + " " + min + " " + min);
            }
            for(int i = (minPos % 2 == 0) ? 1 : 0; i < n; i +=2){
                System.out.println((minPos + 1) + " " + (i + 1) + " " + min + " " + (min + 1));
            }
        }
    }
        
}
