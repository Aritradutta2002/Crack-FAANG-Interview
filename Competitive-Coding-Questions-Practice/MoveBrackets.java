import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveBrackets {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            // int n = Integer.parseInt(r.readLine());
            r.readLine();
            String s = r.readLine().trim();
            int count = 0;
            int max = Integer.MIN_VALUE;
            for(char c : s.toCharArray()){
                if(c == '(')
                    count --;
                else
                    count ++;
                // System.out.println(c + " "+ count);
                max = Math.max(max, count);
            }
            System.out.println(Math.abs(max));
        }
    }
        
}
