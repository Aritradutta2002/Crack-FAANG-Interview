import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class TwoRoundDances {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        long n=Long.parseLong(r.readLine());
        long a1=1;
        for(long i=(n/2+1);i<=n;i++)
            a1*=i;
        // System.out.println(a1);
        for(long i=1;i<=n/2;i++)
            a1/=i;
        // System.out.println(a1);
        long a2=1;
        for(int i=1;i<n/2;i++)
            a2*=i;
        long ans=0;
        if(a1%2==0){
            ans=a1/2;
            ans*=a2;
            ans*=a2;
        }
        else{
            ans=a2/2;
            ans*=a2;
            ans*=a1;
        }
        // System.out.println(a2);
        System.out.println(ans);
    } 
}
