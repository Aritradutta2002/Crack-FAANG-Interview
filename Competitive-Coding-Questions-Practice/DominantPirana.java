import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class DominantPirana {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            int[]array=new int[n];
            StringTokenizer t1=new StringTokenizer(r.readLine());
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(t1.nextToken());
            int n1=array[0];
            boolean same=true;
            for(int i=1;i<n;i++)
                if(array[i]!=n1){
                    same=false;
                    break;
                }
            if(same){
                System.out.println(-1);
                continue;
            }
            int max=Integer.MIN_VALUE;
            for(int i:array)
                max=Math.max(max, i);
            for(int i=0;i<n;i++){
                if(array[i]!=max)
                    continue;
                boolean found=false;
                if(i-1>=0)
                    found=array[i-1]<array[i];
                if(i+1<n)
                    found=found||array[i+1]<array[i];
                if(found){
                    System.out.println((i+1));
                    break;
                }
            }

        }
    } 
}
