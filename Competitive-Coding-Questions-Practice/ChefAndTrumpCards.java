import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class ChefAndTrumpCards {
    static long getCombinations(long n){
        long sum=1;
        long mul=n;
        long div=1;
        long current=1;
        while(mul>0){
            current=(current*mul)/div;
            sum+=current;
            // sum%=1000000007;
            // System.out.println(current);
            mul--;
            div++;
        }
        return sum;
    }
    static long binomialCoeff(int n) 
    { 
        long mul=n;
        long div=1;
        long sum=1;
        while(div<=n/2){
            sum*=mul;
            sum/=div;
            sum=sum%1000000007;
            // System.out.println(sum+" "+div+" "+mul);
            mul--;
            div++;
        }
        // sum=sum%1000000007;
        return sum;

    } 
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            long[]array=new long[n];
            for(int i=0;i<n;i++)
                array[i]=Long.parseLong(data[i]);
            long max=Long.MIN_VALUE;
            for(long i:array)
                max=Math.max(i, max);
            int count=0;
            for(long i:array)
                if(i==max)
                    count++;
            // if(count>=n){
            //     System.out.println(2);
            //     continue;
            // }
            long total=getCombinations(n);
            long subs=0;
            if(count>=2&&count%2==0){
                subs=getCombinations(n-count)*binomialCoeff( count);
                // subs%=1000000007;
            }
            //1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
            //1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 
            // System.out.println(binomialCoeff(200, 100)+" "+getCombinations(200));
            System.out.println(total+" "+subs);
            System.out.println((total-subs)%1000000007);
        }  
    } 
}
