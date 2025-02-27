import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class TheDeliveryFilemma {
    static boolean isPossible(int n,int[]a,int[]b,int total){
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]>total)
                sum += b[i];
            else
                max = Math.max(max, a[i]);
        }

        return max <= total && sum <= total;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            int n=Integer.parseInt(r.readLine());
            int[]a=new int[n];
            int[]b=new int[n];
            StringTokenizer t=new StringTokenizer(r.readLine());
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(t.nextToken());
            t=new StringTokenizer(r.readLine());
            for(int i=0;i<n;i++)
                b[i]=Integer.parseInt(t.nextToken());
            int min = 0;
            int max = Integer.MAX_VALUE;
            int ans = Integer.MAX_VALUE;
            while(min <= max){
                int mid = min + (max - min)/2;
                if(isPossible(n, a, b, mid)){
                    ans = mid;
                    max = mid-1;
                } else {
                    min = mid+1;
                }
            }
            System.out.println(ans);


        } 
    } 
}
