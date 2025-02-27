import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class DistanceAndAxis {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            int n=Integer.parseInt(data[0]);
            int k=Integer.parseInt(data[1]);
            if(n>=k)
                if(n%2==k%2)
                    System.out.println(0);
                else
                    System.out.println(1);
            else
                System.out.println(k-n);
        }
    } 
}