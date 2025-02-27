import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplyBy2DivideBy6 {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 --> 0){
            int n = Integer.parseInt(r.readLine());
            int two = 0, three = 0;
            while(n % 2 == 0){
                n /= 2;
                two++;
            }
            while(n % 3 == 0){
                n /= 3;
                three++;
            }
            if(n != 1 || two > three){
                System.out.println(-1);
                continue;
            }
            System.out.println(2 * three - two);
        }
    }
        
}
