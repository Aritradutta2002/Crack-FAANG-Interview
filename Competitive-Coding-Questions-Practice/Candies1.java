import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Candies1 {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int num = 3;
            long current = 3;
            long n = Integer.parseInt(r.readLine());
            while(current <= num){
                if(n % current == 0){
                    System.out.println(n / current);
                    break;
                }
                current += num++;
            }

        }
    }
        
}
