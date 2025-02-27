import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class CopyPaste {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int n=Integer.parseInt(t1.nextToken());
            int k=Integer.parseInt(t1.nextToken());
            StringTokenizer t2=new StringTokenizer(r.readLine());
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(t2.nextToken());
            int min=Integer.MAX_VALUE;
            int pos=0;
            for(int i=0;i<n;i++)
                if(array[i]<min){
                    pos=i;
                    min=array[i];
                }
            array[pos]=Integer.MAX_VALUE;
            int count=0;
            for(int i=0;i<n;i++){
                if(k-array[i]>=0)
                    count+=(k-array[i])/min;
            }
            System.out.println(count);
            
        }
    } 
}
