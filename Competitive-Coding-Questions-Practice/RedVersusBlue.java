import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RedVersusBlue {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int tt = Integer.parseInt(r.readLine());
        while(tt -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int m = Integer.parseInt(t.nextToken());
            int l = Integer.parseInt(t.nextToken());

            StringBuilder b = new StringBuilder();
            int num = m / (l + 1)+ ((m % (l + 1) == 0) ? 0 : 1);
            while( l > 0 || m > 0){
                for(int i = 0; i < num && m > 0; i++){
                    b.append("R");
                    m--;
                }

                if( l > 0){
                    b.append("B");
                    l--;
                }
            }

            System.out.println(b);
        }
    }
        
}
