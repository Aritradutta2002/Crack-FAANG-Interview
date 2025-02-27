import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class NickAndArray {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        StringTokenizer t=new StringTokenizer(r.readLine());
        long[]array=new long[n];
        for(int i=0;i<n;i++)
            array[i]=Long.parseLong(t.nextToken());
        long[]pos=new long[n];
        for(int i=0;i<n;i++){
            if(array[i]>=0)
                pos[i]=array[i];
            else
                pos[i]=-array[i]-1;

        }
        long max=Long.MIN_VALUE;
        int maxPos=0;
        for(int i=0;i<n;i++)
            if(pos[i]>max){
                max=pos[i];
                maxPos=i;
            }
        StringBuilder b=new StringBuilder();
        for(int i=0;i<n;i++){
            if(i!=maxPos||n%2==0){
                if(array[i]<0)
                    b.append(array[i]);
                else
                    b.append((-array[i]-1));
            }
            else{
                if(array[i]>=0)
                    b.append(array[i]);
                else
                    b.append((-array[i]-1));
            }
            b.append(" ");
        }
        System.out.println(b);

    } 
}
