import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class KAmazingNumbers {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(t1.nextToken());
            int []lastPos=new int[n+1];
            int []freq=new int[n+1];
            Arrays.fill(lastPos, -1);
            for(int i=0;i<n;i++){
                int gap=Math.abs(i-lastPos[array[i]]);
                freq[array[i]]=Math.max(gap, freq[array[i]]);
                lastPos[array[i]]=i;
            }
            for(int i=0;i<n;i++){
                int gap=Math.abs(n-lastPos[array[i]]);
                freq[array[i]]=Math.max(gap,freq[array[i]]);
            }
            lastPos=null;
            int [] least=new int [n];
            Arrays.fill(least, Integer.MAX_VALUE);
            for(int i=0;i<=n;i++)
                if(freq[i]!=0)
                    least[freq[i]-1]=Math.min(least[freq[i]-1], i);
            for(int i=1;i<n;i++)
                least[i]=Math.min(least[i], least[i-1]);
            StringBuilder b=new StringBuilder();
            for(int i=0;i<n;i++)
                if(least[i]==Integer.MAX_VALUE)
                    b.append("-1 ");
                else
                    b.append(least[i]+" ");
            System.out.println(b);
        } 
    } 
}
