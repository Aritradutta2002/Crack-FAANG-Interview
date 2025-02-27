import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 class PolygonRelationship {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            int m=n;
            while(m-->0)
                r.readLine();
            int count=0;
            while(n>2){
                count+=n;
                n/=2;
            }
            System.out.println(count);
        } 
    } 
}