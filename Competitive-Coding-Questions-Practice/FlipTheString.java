import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FlipTheString {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 --> 0){
            String s1 = r.readLine().trim();
            String s2 = r.readLine().trim();
            int n = s1.length();
            int count = 0;
            int i = 0;
            while(i < n){
                if(s1.charAt(i) == s2.charAt(i)){
                    i += 2;
                    continue;
                }
                int j = i + 2;
                while(j < n){
                    if(s1.charAt(j) == s2.charAt(j))
                        break;
                    j += 2;
                }
                count++;
                i = j + 2;
            }
            i = 1;
            while(i < n){
                if(s1.charAt(i) == s2.charAt(i)){
                    i += 2;
                    continue;
                }
                int j = i + 2;
                while(j < n){
                    if(s1.charAt(j) == s2.charAt(j))
                        break;
                    j += 2;
                }
                count++;
                i = j + 2;
            }
            System.out.println(count);
        }
    }
        
}
