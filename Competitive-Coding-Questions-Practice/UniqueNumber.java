import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniqueNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int x = Integer.parseInt(r.readLine());
            int current = 9;
            StringBuilder b = new StringBuilder();
            while(current > 0 && x > 0){
                int num = Math.min(current, x);
                b.append(num);
                x -= current--;
            }
            if(x > 0)
                System.out.println(-1);
            else
                System.out.println(b.reverse());

        }
    }
        
}
