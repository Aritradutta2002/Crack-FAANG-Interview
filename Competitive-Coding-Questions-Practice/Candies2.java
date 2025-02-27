import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Candies2 {
    static boolean check(long n,long k){
        if(n==k)
            return true;
        if(k==0)
            return false;
        long rem=n;
        long count=0;
        while(rem>0){
            count+=Math.min(k, rem);
            rem-=k;
            rem=rem-rem/10;
            // System.out.println(rem);
        }
        if(n%2==0)
            return count>=n/2;
        else return count>n/2; 
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        long n=Long.parseLong(r.readLine());
        long min=0;
        long max=n;
        long ans=n;
        while(min<=max){
            long mid=min+(max-min)/2;
            if(check(n, mid)){
                ans=mid;
                max=mid-1;
            }
            else
                min=mid+1;
        }
        System.out.println(ans);

    } 
}