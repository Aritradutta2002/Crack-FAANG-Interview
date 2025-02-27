import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddCandies {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1-->0){
            int n = Integer.parseInt(r.readLine());
            System.out.println(n);
            for(int i = 0; i < n ; i++)
                System.out.print((i+1)+" ");
            System.out.println();
        }
    }
        
}
