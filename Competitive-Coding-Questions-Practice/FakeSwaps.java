import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class FakeSwaps {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            String s1 = r.readLine();
            String s2 = r.readLine();
            int o = 0, z = 0;
            for(char c : s2.toCharArray())
                if(c == '0')
                    z++;
                else
                    o++;
            if((o > 0 && z > 0) || s1.equals(s2))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
        
}
