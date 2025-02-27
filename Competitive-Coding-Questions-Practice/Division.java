import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Division {
    
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            StringTokenizer t=new StringTokenizer(r.readLine());
            long p=Long.parseLong(t.nextToken());
            long q=Long.parseLong(t.nextToken());
            if(p==q){
                System.out.println(1);
            }
            else if(p<q){
                System.out.println(p);
            }
            else if(p%q!=0)
                System.out.println(p);
            else{
                long ans = 1;
                for(long i = (long)Math.ceil(Math.sqrt(q))+1;i>=2;i--){
                    if(q%i==0){
                        long temp = p;
                        while(temp % i == 0){
                            temp /= i;
                        }
                        if(p%temp==0&&temp%q!=0){
                            ans = Math.max(temp,ans);
                            // break;
                        }
                    }
                    long j=q/i;
                    if(q%j==0&&j!=1){
                        long temp = p;
                        while(temp % j == 0){
                            temp /= j;
                        }
                        if(p%temp==0&&temp%q!=0){
                            ans = Math.max(temp,ans);
                            // break;
                        }
                    }

                }
                
                System.out.println(ans);
            }
        }    
    } 
}
