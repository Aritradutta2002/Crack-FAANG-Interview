import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BinarySearch {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t=new StringTokenizer(r.readLine());
        int n=Integer.parseInt(t.nextToken());
        int x=Integer.parseInt(t.nextToken());
        int pos=Integer.parseInt(t.nextToken());
        int left=0;
        int right=n;
        int smaller=0 , greater=0;
        while(left<right){
            int middle=(left+right)/2;
            if(middle==pos){
                left=middle+1;
            }
            else if(middle>pos){
                greater++;
                right=middle;
            }
            else{
                smaller++;
                left=middle+1;
            }
        } 
        long mod=1000000007;
        long ans=1;
        int more=n-x;
        int less=x-1;
        // System.out.println(greater);
        // if(smaller>=x){
        //     System.out.println(0);
        //     return;
        // }
        for(int i=0;i<greater;i++){
            ans*=more;
            ans%=mod;
            more--;
        }
        for(int i=0;i<smaller;i++){
            ans*=less;
            ans%=mod;
            less--;
        }
        more+=less;
        while(more>1){
            ans*=more;
            ans%=mod;
            more--;
        }
        System.out.println(Math.max(ans, 0));

    } 
}
