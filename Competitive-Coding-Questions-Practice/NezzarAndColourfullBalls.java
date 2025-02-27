import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NezzarAndColourfullBalls {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1  =Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n; i++)
                array[i] = Integer.parseInt(t.nextToken());
            int ptr1 = 0;
            int count = 1;
            while(ptr1 < n){
                int ptr2 = ptr1 + 1;
                while(ptr2 < n && array[ptr2] == array[ptr1])
                    ptr2++;
                count = Math.max(ptr2 - ptr1, count);
                ptr1 = ptr2;
            }
            System.out.println(count);
        }
    }
        
}
