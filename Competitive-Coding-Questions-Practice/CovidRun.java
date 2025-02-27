import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class CovidRun {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int n=Integer.parseInt(t1.nextToken());
            int k=Integer.parseInt(t1.nextToken());
            int x=Integer.parseInt(t1.nextToken());
            int y=Integer.parseInt(t1.nextToken());
            k=k%n;
            boolean found=false;
            for(int i=0;i<2*n;i++){
                x=(x+k)%n;
                if(x==y){
                    found=true;
                    break;
                }
            }
            if(found)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    } 
}
