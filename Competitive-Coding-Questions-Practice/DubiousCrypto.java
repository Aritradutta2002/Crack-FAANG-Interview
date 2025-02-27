import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class DubiousCrypto {
    public static void main(String[] args) throws IOException{
        BufferedReader rr=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(rr.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer(rr.readLine());
            long l=Long.parseLong(t1.nextToken());
            long r=Long.parseLong(t1.nextToken());
            long m=Long.parseLong(t1.nextToken());
            long diff=r-l;
            if(m==0){
                System.out.println(l+" "+l+" "+l);
            }
            //ss`
            for(long i=l;i<=r;i++){
                if(m%i<=diff&&m/i!=0){
                    System.out.println(i+" "+r+" "+(r-m%i));
                    break;
                }
                if(i-m%i<=diff){
                    System.out.println((i)+" "+(r-(i-m%i))+" "+r);
                    break;
                }
            }

        } 
    } 
}
