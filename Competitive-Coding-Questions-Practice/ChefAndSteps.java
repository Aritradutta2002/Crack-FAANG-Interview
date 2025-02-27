import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 class ChefAndSteps {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer (r.readLine());
            int n=Integer.parseInt(t1.nextToken());
            int k=Integer.parseInt(t1.nextToken());
            t1=new StringTokenizer(r.readLine());
            StringBuilder b=new StringBuilder();
            for(int i=0;i<n;i++){
                int num=Integer.parseInt(t1.nextToken());
                if(num%k==0)
                    b.append('1');
                else
                    b.append('0');
            }
            System.out.println(b);
        } 
    } 
}
