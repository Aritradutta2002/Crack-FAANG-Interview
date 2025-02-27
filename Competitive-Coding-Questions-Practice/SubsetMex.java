import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SubsetMex {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int[]freq=new int[101];
            for(int i=0;i<n;i++)
                freq[Integer.parseInt(t1.nextToken())]++;
            int sum=0;
            boolean c1=false,c2=false;
            for(int i=0;i<101;i++){
                if(freq[i]<1&&!c1){
                    sum+=i;
                    c1=true;
                }
                if(freq[i]<2&&!c2){
                    sum+=i;
                    c2=true;
                }   
                if(c1&&c2)
                    break;
            }
            System.out.println(sum);
            
        }        

    } 
}
