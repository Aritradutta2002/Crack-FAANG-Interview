import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialPermutation2 {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(r.readLine());
            if(n < 4){
                System.out.println( -1 );
                continue;
            }
            
            int[]array = new int[n];
            int ptr = 0;

            for(int i = n - n % 2; i > 0; i -= 2)
                if(i != 4)
                    array[ptr++] = i;
                
            array[ptr++] = 4;

            for(int i = 1; i <= n; i += 2)
                array[ptr++] = i;

            StringBuilder b = new StringBuilder();

            for(int i : array){
                b.append(i);
                b.append(" ");
            }
            System.out.println(b);

        }
    }
        
}
