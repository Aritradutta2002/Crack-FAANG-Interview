import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int k = Integer.parseInt(t.nextToken());
            String s = r.readLine();
            StringBuilder b = new StringBuilder();
            int ptr = 0;
            for(int i = 0; i < n ; i ++){
                b.append(s.charAt(ptr));
                ptr = (ptr + 1) % k;
            }
            System.out.println(b);
        }
    }
        
}
