import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoBrackets {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        while(t-->0){
            String s = r.readLine();
            int n = s.length();
            int c1 =0,c2=0;
            int count=0;
            for(int i=0;i<n;i++){
                char c = s.charAt(i);
                if(c=='[')
                    c1++;
                if(c=='(')
                    c2++;
                if(c==']'&&c1>0){
                    count++;
                    c1--;
                }
                if(c==')'&&c2>0){
                    count++;
                    c2--;
                }

            }
            System.out.println(count);
        }
    }
        
}
