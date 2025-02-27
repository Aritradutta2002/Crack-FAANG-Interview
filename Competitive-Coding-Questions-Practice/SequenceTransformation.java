import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SequenceTransformation {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n; i++)
                array[i] = Integer.parseInt(t.nextToken());
            
            ArrayList<Integer> list = new ArrayList<>();
            list.add(array[0]);
            int last = array[0];
            int max = Integer.MIN_VALUE;
            for(int i : array){
                if(last != i)
                    list.add(i);
                last = i;
                max = Math.max(max, i) ;    
            }
            int[]freq = new int[max + 1];
            int size = list.size();
            for(int i = 1; i < size - 1; i++){
                freq[list.get(i)] ++;
            }
            // System.out.println(list);
            int min = Integer.MAX_VALUE;
            for(int i :list)
                min = Math.min(freq[i], min);
            if(size == 1)
                System.out.println(0);
            else if(size == 2)
                System.out.println(1);
            else 
                System.out.println(min + 1);
            
            
        }
    }
        
}
