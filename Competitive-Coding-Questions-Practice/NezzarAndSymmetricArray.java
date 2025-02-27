import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * NezzarAndSymmetricArray
 */
public class NezzarAndSymmetricArray {

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            long []arr = new long[n * 2];
            for (int i = 0; i < n * 2; i++)
                arr[i] = Long.parseLong(t.nextToken());
            long[]array = new long[n];
            Arrays.sort(arr);
            HashSet<Long>s = new HashSet<>();
            boolean c = true;
            for(long i : arr)
                if(i % 2 != 0 || i <= 0)
                    c = false;
            for(int i = 0; i < n * 2; i += 2){
                array[i / 2] = arr[i] / 2;
                s.add(arr[i] / 2);
                if(arr[i] != arr[i + 1])
                    c = false;
            }
            if(array.length != s.size())
                c= false;
            long sum = 0;
            for(int i = n - 1; i >= 0; i --){
                array[i] -= sum;
                // System.out.println(array[i] + " " + (i + 1));
                if(array[i] % (long)(i + 1) != 0 || array[i] / (long)(i + 1) < 1 || array[i] < 1)
                    c = false;
                sum += array[i] / (long)(i + 1);
            }

            if(c)
                System.out.println("YES");
            else
                System.out.println("NO");
            

        }
    }
    
}