import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class XORwise {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int n1=Integer.parseInt(t1.nextToken());
            int n2=Integer.parseInt(t1.nextToken());
            int and=n1&n2;
            int ans=(n1^and)+(n2^and);
            System.out.println(ans);
        } 
    } 
}
