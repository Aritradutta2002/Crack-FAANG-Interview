import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecificTasteOfAndre {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        while(t --> 0){
            int n = Integer.parseInt(r.readLine());
            StringBuilder b = new StringBuilder();
            while(n-- > 0){
                b.append("1 ");
            }
            System.out.println(b);
        }
    }
        
}
