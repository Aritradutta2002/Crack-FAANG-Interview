import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NearestSmallerValues {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        StringTokenizer t = new StringTokenizer(r.readLine());
        int[]array = new int[n+1];
        for(int i = 1; i <= n; i++)
            array[i] = Integer.parseInt(t.nextToken());
        
        int[] stack = new int[n+1];
        int ptr = 1;
        for(int i = 1; i <= n; i++){
            int num = array[i];
            while(array[stack[ptr-1]] >= num)
                ptr --;
            System.out.print((stack[ptr-1])+" ");
            stack[ptr] = i;
            ptr++;
        }
        System.out.println();

    }
        
}
