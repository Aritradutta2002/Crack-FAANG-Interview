import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class MaximizeFunction{
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n; i++)
                array[i] = Integer.parseInt(t.nextToken());
            
            Arrays.sort(array);

            long min = array[0], max = array[n - 1];
            long a = Integer.MIN_VALUE;
            for(int i = 1; i < n - 1; i ++)
                a = Math.max(a, (Math.abs(array[i] - min) + Math.abs(max - array[i]) + Math.abs(max - min)));

            System.out.println(2L*(Math.abs(max - min)));

        }
    }
    
}