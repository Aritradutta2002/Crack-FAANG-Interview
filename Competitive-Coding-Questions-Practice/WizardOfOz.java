import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WizardOfOz {
    static int get(int n){
        if(n == 9)
            return 0;
        return ++n;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        while(t -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringBuilder b = new StringBuilder();
            int c = 8;
            for(int i = 0; i < n; i++)
                if(i == 0)
                    b.append(9);
                else if(i == 1)
                    b.append(8); 
                else{
                    c = get(c);
                    b.append(c);
                }
            System.out.println(b);
        }
    }
        
}
