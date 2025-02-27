import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class NationalProject {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            int n=Integer.parseInt(data[0]);
            int g=Integer.parseInt(data[1]);
            int b=Integer.parseInt(data[2]);
            int gwanted=n/2;
            if(n%2!=0)
                gwanted++;
            int setsReq=gwanted/g;
            long count=0;
            count+=(long)setsReq*g+(long)(setsReq-1)*(b);
            if(gwanted%g!=0){
                count+=gwanted%g;
                count+=b;
            }
            if(count<n)
                count+=(n-count);
            System.out.println(count);
        }
    } 
}