import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicalCalander {
    public static void main(String[] args)throws IOException {
        BufferedReader R=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(R.readLine());
        while(t-->0){
            String[]data=R.readLine().split(" ");
            long n=Long.parseLong(data[0]);
            long r=Long.parseLong(data[1]);
            long before,after;
            // long ans;
            if(n<=r){
                before=n-1;
                after=r-n+1;
            }
            else{
                after=0;
                before=r;
            }
            long ans=1+(before*(before+1))/2;
            if(after==0)
                ans--;
            System.out.println(ans);
        }
    }
}