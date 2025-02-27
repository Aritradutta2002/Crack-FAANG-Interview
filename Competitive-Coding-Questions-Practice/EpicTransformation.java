import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EpicTransformation {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1  = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n ; i++)
                array[i] = Integer.parseInt(t.nextToken());

            Arrays.sort(array);

            ArrayList<Integer>count = new ArrayList<>();

            int ptr = 0;
            while(ptr < n){
                int j = ptr;
                while(j < n)
                    if(array[j] == array[ptr])
                        j++;
                    else
                        break;
                count.add(j - ptr);
                ptr = j;
            }
            ptr = 0;
            n = count.size();
            long []a = new long[n];
            for(int i = 0; i < n; i ++)
                a[i] = count.get(i);
            
            Arrays.sort(a);
            long left = 0;
            for(long i : a){
                if(left > i)
                    left -= i;
                else{
                    
                }
            }
        }
    }
        
}
