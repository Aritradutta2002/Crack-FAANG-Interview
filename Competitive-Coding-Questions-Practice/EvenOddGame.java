import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EvenOddGame {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            Integer[]array = new Integer[n];
            for(int i = 0; i < n; i ++)
                array[i] = Integer.parseInt(t.nextToken());
            Arrays.sort(array);
            int ptr = n - 1;
            long a = 0, b = 0;
            for(int i = 0; i < n; i++){
                if(i % 2 == 0 && array[ptr] % 2 == 0)
                    a += array[ptr];
                else if(i % 2 == 1 && array[ptr] % 2 == 1)
                    b +=array[ptr];
                ptr --;
            }
            if(a > b)
                System.out.println("Alice");
            else if(a < b)
                System.out.println("Bob");
            else
                System.out.println("Tie");
        }
    }
        
}
