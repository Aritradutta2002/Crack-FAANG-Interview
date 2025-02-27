import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DoubleEndedStrings {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        while(n -- > 0){
            String s1 = r.readLine();
            String s2 = r.readLine();
            int n1 = s1.length();
            int n2 = s2.length();
            int max = 0;
            for(int i = 0; i < n1 ; i++){
                for(int j = 0; j < n2; j ++){
                    int p1 = i;
                    int p2 = j;
                    while(p1 < n1 && p2 < n2 && s1.charAt(p1) == s2.charAt(p2)){
                        p1++;
                        p2++;
                    }
                    max = Math.max(max, p1 - i);
                }
            }
            System.out.println((n1 + n2 - 2 * max));
        }
    }
        
}
