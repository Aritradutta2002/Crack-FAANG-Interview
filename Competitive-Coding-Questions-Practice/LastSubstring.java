import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastSubstring {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            String s = r.readLine().trim();
            if(n >= 4){
                if(s.subSequence(0, 2).equals("20") && s.subSequence(n - 2, n).equals("20")||
                s.subSequence(0, 3).equals("202") && s.subSequence(n - 1, n).equals("0")||
                s.subSequence(0, 1).equals("2") && s.subSequence(n - 3, n).equals("020")||
                s.subSequence(0, 4).equals("2020")||
                s.subSequence(n - 4, n).equals("2020"))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            else
                System.out.println("NO");
        }
    }
        
}
