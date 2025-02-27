import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SequenceAndSwaps{
    static boolean check(int[]array){
        int[] cpy = Arrays.copyOf(array, array.length);
        Arrays.sort(cpy);
        for(int i = 0; i < array.length; i ++)
            if(array[i] != cpy[i])
                return false;

        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int x = Integer.parseInt(t.nextToken());
            int[]array = new int[n];
            t = new StringTokenizer(r.readLine());
            for(int i = 0; i < n; i++)
                array[i] = Integer.parseInt(t.nextToken());

            if(check(array)){
                System.out.println(0);
                continue;
            }

            int count = 0;
            for(int i = 0; i < n; i++)
                if(array[i] > x){
                    int temp = x;
                    x = array[i];
                    array[i] = temp;
                    count ++;
                    if(check(array))
                        break;
                }  
            if(!check(array))
                System.out.println(-1);
            else
                System.out.println(count);

        }
    }
    
}