import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaxAndMex {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int k = Integer.parseInt(t.nextToken());
            t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i <n; i++)
                array[i] = Integer.parseInt(t.nextToken());
            Arrays.sort(array);

            int mex = array[n - 1] + 1;
            for(int i = 0; i < n; i ++)
                if(array[i] != i){
                    mex = i;
                    break;
                }

            int max = array[n - 1];
            int newNum = (int)Math.ceil((float)(max + mex) / 2.0);

            if(newNum > max)
                n += k;
            else
                if(Arrays.binarySearch(array, newNum) < 0 && k > 0)
                    n++;
            System.out.println(n);
        }
    }
        
}
