import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrangeFunction {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            System.out.println(r.readLine().trim().length());
        }
    }
        
}
