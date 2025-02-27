import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * RedBlueShuffle
 */
public class RedBlueShuffle {

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        // String s = "sdasd"
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            String s1 = r.readLine(), s2 = r.readLine();
            int n1 = 0, n2 = 0;
            for(int i = 0 ; i < n; i ++)
                if(Integer.parseInt(Character.toString(s1.charAt(i))) > Integer.parseInt(Character.toString(s2.charAt(i)))){
                    n1++;
                } else if(Integer.parseInt(Character.toString(s1.charAt(i))) < Integer.parseInt(Character.toString(s2.charAt(i))))
                    n2++;

            if(n1 > n2)
                System.out.println("RED");
            else if(n1 < n2)
                System.out.println("BLUE");
            else
                System.out.println("EQUAL");
        }

        
        
    }
    
}