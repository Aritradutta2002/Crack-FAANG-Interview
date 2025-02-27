import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class IncreaseAndCopy {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        while(t-->0){
            int n = Integer.parseInt(r.readLine());
            int min = n;
            for(int i=1;i<=Math.sqrt(n);i++){
                int count = (int) Math.ceil((double)n/(double)i) - 1;
                count+= i - 1;
                min = Math.min(count, min);
            }
            System.out.println( min );
        }
    } 
}
