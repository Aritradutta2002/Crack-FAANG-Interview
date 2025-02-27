import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YetAnotherStringGame {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            char[] s = r.readLine().trim().toCharArray();
            int n = s.length;
            boolean turn = true;
            for(int i = 0; i < n; i++){
                if(turn){
                    if(s[i] == 'a')
                        s[i] = 'b';
                    else
                        s[i] = 'a';
                } else {
                    if(s[i] == 'z')
                        s[i] = 'y';
                    else
                        s[i] = 'z';
                }
                turn = !turn;
            }
            StringBuilder b = new StringBuilder();
            for (char c : s)
                b.append(c);
            System.out.println(b);

        }
    }
        
}
