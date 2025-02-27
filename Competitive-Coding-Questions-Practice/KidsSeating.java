import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class KidsSeating {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            int n=Integer.parseInt(r.readLine());
            int num=n*2;
            while(n-->0){
                System.out.print(num+" ");
                num+=2;
            }
            System.out.println();
        } 
    } 
}
