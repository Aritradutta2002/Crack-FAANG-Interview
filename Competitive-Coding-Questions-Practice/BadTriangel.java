import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BadTriangel {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            if(Integer.parseInt(data[0])+Integer.parseInt(data[1])>Integer.parseInt(data[n-1]))
                System.out.println(-1);
            else
                System.out.println(1+" "+2+" "+(n));
        }
    } 
}