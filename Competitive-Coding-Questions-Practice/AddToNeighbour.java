import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AddToNeighbour {
    static int check(int count, int[]array, int n){
        long sum = 0;
        int ptr = 0;
        for(int i= 0 ;i <= count; i++)
            sum+=array[ptr ++];
        
        while(ptr < n){
            long current = array[ptr];
            int j = ptr + 1;
            while(current < sum && j < n){
                current += array[j++];
                count++;
            }
            if(current != sum)
                return Integer.MAX_VALUE;
            ptr = j;
            
        }
        

        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n ; i++)
                array[i] = Integer.parseInt(t.nextToken());
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++)
                min = Math.min(min, check(i, array, n));
            if(min == Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(min);
        }
    }
    
    
}
