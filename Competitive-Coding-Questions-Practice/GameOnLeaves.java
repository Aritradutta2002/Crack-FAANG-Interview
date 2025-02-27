import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameOnLeaves {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int x = Integer.parseInt(t.nextToken());
            int count = 0;
            for(int i = 0; i < n - 1; i++){
                t = new StringTokenizer(r.readLine());
                int n1 = Integer.parseInt(t.nextToken());
                int n2 = Integer.parseInt(t.nextToken());
                if(n1 == x || n2 == x)
                    count ++;
            }
            if(count == 1 || n < 2){
                System.out.println("Ayush");
                continue;
            }
            n -= 2 + 1;
            // System.out.println(n);
            if(n % 2 == 0)
                System.out.println("Ashish");
            else
                System.out.println("Ayush");
        }
    }
        
}
