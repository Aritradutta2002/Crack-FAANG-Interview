import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Elemination {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            StringTokenizer t=new StringTokenizer(r.readLine());
            int a=Integer.parseInt(t.nextToken());
            int b=Integer.parseInt(t.nextToken());
            int c=Integer.parseInt(t.nextToken());
            int d=Integer.parseInt(t.nextToken());
            System.out.println(Math.max(a+b,c+d));
        }
    } 
}
