import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubtractOrDivide {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        while(t --> 0){
            int n = Integer.parseInt(r.readLine());
            if(n==1)
                System.out.println(0);
            else if(n==2)
                System.out.println(1);
            else if(n%2 ==0 || n==3)
                System.out.println(2);
            else 
                System.out.println(3);
        }
    }
        
}
