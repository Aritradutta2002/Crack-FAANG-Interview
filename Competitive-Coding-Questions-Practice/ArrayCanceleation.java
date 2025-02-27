import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ArrayCanceleation {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            long cost=0;
            long available=0;
            for(int i:array){
                if(i<0){
                    i=Math.abs(i);
                    long rem=Math.min(available, i);
                    available-=rem;
                    cost+=(i-rem);
                }
                else
                    available+=i;
            }
            // System.out.println(available+" "+cost);
            System.out.println((available+cost)/2);
        } 
    } 
}
