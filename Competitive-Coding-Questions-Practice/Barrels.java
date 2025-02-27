import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Barrels {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String[]data1=r.readLine().split(" ");
        int n=Integer.parseInt(data1[0]);
        int k=Integer.parseInt(data1[1]);
        int l=Integer.parseInt(data1[2]);
        String[]data=r.readLine().split(" ");
        long[]array=new long[k*n];
        for(int i=0;i<n*k;i++)
            array[i]=Long.parseLong(data[i]);
        long[]found=new long[n];
        int ptr=1;
        Arrays.sort(array);
        found[0]=array[0];
        for(int i=n;i<n*k&&ptr<n;i++){
            if(array[i]-array[0]<=l){
                found[ptr]=array[i];
                ptr++;
            }
        }
        for(int i=n-1;i>0&&ptr<n;i--){
            if(array[i]-array[0]<=l){
                found[ptr]=array[i];
                ptr++;
            }
        }
        long sum=0;
        for(long i:found)
            sum+=i;
        if(ptr<n)
            sum=0;
        System.out.println(sum);
 
    } 
}