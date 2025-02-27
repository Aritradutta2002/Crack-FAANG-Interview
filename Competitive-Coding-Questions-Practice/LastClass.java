import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastClass {
    public static void main(String[]args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            int num=2;
            int ans=0;
            while(num<100000){
                if(n%num==0){
                    ans=num;
                    break;
                }
                num++;
            }
            if(ans==0){
                ans=n;
            }
            System.out.println((n/ans)+" "+(n-n/ans));
            
        }
    }
}