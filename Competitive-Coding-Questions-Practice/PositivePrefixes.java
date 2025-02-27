import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 class PositivePrefixes {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int k = Integer.parseInt(t.nextToken());
            int[]array = new int[n];
            for(int i = 0; i < n; i ++)
                array[i] = i + 1;

            k = n - k;

            for(int i = 0; i < n && k > 0; i += 2, k --)
                array[i] = - array[i];
            for(int i = n - n % 2 - 1; i >= 0 && k > 0; i -= 2, k --)
                array[i] = - array[i];

            StringBuilder b = new StringBuilder();
            for(int i : array){
                b.append(i);
                b.append(" ");
            }
            System.out.println(b);

        }
    }
        
}
