import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class CorruptedArray {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine()) + 2;
            int[] arr = new int[n];
            ArrayList<Integer>sort = new ArrayList<>();
            StringTokenizer t = new StringTokenizer(r.readLine());
            long sum = 0;
            for(int i = 0; i < n; i ++){
                sort.add(Integer.parseInt(t.nextToken()));
                arr[i] = sort.get(i);
                sum += arr[i];
            }

            Collections.sort(sort);
            boolean f = false;
            
            for(int i = 0; i < n && !f; i ++){
                long want = sum - arr[i];
                int max = (arr[i] == sort.get(n - 1)) ? sort.get(n - 2) : sort.get(n - 1);
                // System.out.println(want + " " + max);
                if(want == ((long)max) * 2L){
                    StringBuilder b = new StringBuilder();
                    boolean skip = false;
                    for(int j = 0; j < n; j ++){
                        if(i == j)
                            continue;
                        if(!skip && max == arr[j]){
                            skip = true;
                            continue;
                        }
                        b.append(arr[j]);
                        b.append(" ");
                    }
                    System.out.println(b);
                    f = true;
                    break;
                    
                }

                
            }
            if(!f)
                System.out.println(-1);
        }
    }
        
}
