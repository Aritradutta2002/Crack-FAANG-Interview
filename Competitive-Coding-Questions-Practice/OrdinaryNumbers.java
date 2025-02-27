import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.StringTokenizer;

public class OrdinaryNumbers {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            long n = Integer.parseInt(r.readLine());
            int c = 0;
            for(int i = 1; i < 10; i ++){
                StringBuilder b = new StringBuilder();
                for(int j = 0; j < 12; j++){
                    b.append(i);
                    long num = Long.parseLong(b.toString());
                    if(num <= n)
                        c++;
                    // System.out.println(num);
                }
            }

            System.out.println(c);
        }
    }
        
}
