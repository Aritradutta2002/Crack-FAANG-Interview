import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class EvenPicture {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        System.out.println((6+n+(n-1)*2));
        for(int i=0;i<n+1;i++){
            System.out.println(i+" "+i);
            System.out.println(i+" "+(i+1));
            System.out.println((i+1)+" "+(i));
        } 
        System.out.println((n+1)+" "+(n+1));
    } 
}
