import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PuzzelFromTheFuture {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            String s = r.readLine().trim();
            int last = 0;

            StringBuilder b = new StringBuilder();
            
            for(int i = 0; i < n; i ++){
                char c = s.charAt(i);
                
                if(c == '1'){
                    if(last == 2){
                        last = 1;
                        b.append(0);
                    } else {
                        last = 2;
                        b.append(1);
                    }
                } else {
                    if(last == 1){
                        last = 0;
                        b.append(0);
                    } else {
                        last = 1;
                        b.append(1);
                    }
                }
            }

            System.out.println(b);
        }
    }
        
}
