import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class ArrayRearangement {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1 = new StringTokenizer(r.readLine());
            int n=Integer.parseInt(t1.nextToken());
            int k=Integer.parseInt(t1.nextToken());
            int[]a=new int[n];
            int []b=new int[n];
            t1=new StringTokenizer(r.readLine());
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(t1.nextToken());
            t1=new StringTokenizer(r.readLine());
            for(int i=0;i<n;i++)
                b[i]=Integer.parseInt(t1.nextToken());
            boolean check=true;
            for(int i=0;i<n;i++){
                if(a[i]+b[n-i-1]>k){
                    check=false;
                    break;
                }
            }
            if(check)
                System.out.println("YES");
            else
                System.out.println("NO");
            if(t!=0)
                r.readLine();
        } 
    } 
}
