import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SunsequenceHate {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            String s=r.readLine();
            int n=s.length();
            int count=0;
            int[]zeroBehind=new int[n];
            int[]zeroAhead=new int[n];
            int[]oneBehind=new int[n];
            int[]oneAhead=new int[n];
            for(int i=0;i<n;i++){
                zeroBehind[i]=count;
                if(s.charAt(i)=='0')
                    count++;
            }
            count=0;
            for(int i=0;i<n;i++){
                oneBehind[i]=count;
                if(s.charAt(i)=='1')
                    count++;
            }
            count=0;
            for(int i=n-1;i>=0;i--){
                zeroAhead[i]=count;
                if(s.charAt(i)=='0')
                    count++;
            }
            count=0;
            for(int i=n-1;i>=0;i--){
                oneAhead[i]=count;
                if(s.charAt(i)=='1')
                    count++;
            }
            int min=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                min=Math.min(oneAhead[i]+zeroBehind[i],min);
                min=Math.min(zeroAhead[i]+oneBehind[i],min);
            }
            System.out.println(min);

        } 
    } 
}
