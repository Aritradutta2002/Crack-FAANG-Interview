import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 10    
// 10 1000
// 001100111
public class BinaryStringMinimizing {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int n=Integer.parseInt(t1.nextToken());
            long k=Long.parseLong(t1.nextToken());
            String []s=r.readLine().split("");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(s[i]);
            int lastPos=0;
            for(int i=0;i<n;i++){
                if(array[i]==0){
                    int diff=(int)Math.min(k, i-lastPos);
                    k-=diff;
                    if(i-diff<0)
                        continue;
                    array[i]=1;
                    array[i-diff]=0;
                    lastPos++;
                }
                if(k<=0)
                    break;
            }
            StringBuilder b=new StringBuilder();
            for(int i:array)
                b.append(i);
            System.out.println(b);
        } 
    } 
}
