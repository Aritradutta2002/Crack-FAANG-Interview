import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalanceTheBits {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            String s = r.readLine();

            StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();

            int cnt = 0;
            boolean b = true;
            boolean check = true;
            for(char c : s.toCharArray()){
                if(b){
                    s1.append('(');
                    if(c == '1'){
                        s2.append('(');
                        cnt++;
                    } else {
                        s2.append(')');
                        if(cnt > 0 )
                            cnt --;
                        else
                            check = false;
                    }
                } else {
                    s1.append(')');
                    if(c == '1'){
                        s2.append(')');
                        if(cnt > 0)
                            cnt --;
                        else
                            check = false;     
                    } else {
                        s2.append('(');
                        cnt++;
                    }
                }
                b = !b;
            }
            check = check && cnt == 0;
            if(check){
                System.out.println("YES");
                System.out.println(s1);
                System.out.println(s2);
            } else {
                System.out.println("NO");
            }

        }
        
    }
        
}
