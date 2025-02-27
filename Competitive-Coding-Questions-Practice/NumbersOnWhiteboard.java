import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class NumbersOnWhiteboard {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            int last=n;
            System.out.println(2);
            for(int i=n-1;i>0;i--){
                System.out.println(i+" "+last);
                last=(int)Math.ceil(((double)(i+last))/2.0);
            }
        } 
    } 
}
