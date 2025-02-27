import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialPermutation {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        while(t -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringBuilder b = new StringBuilder();
            for(int i = 0; i < n; i++){
                b.append((i + 1) % n + 1);
                b.append(" ");
            }
            System.out.println(b);
        }
    }
        
}
