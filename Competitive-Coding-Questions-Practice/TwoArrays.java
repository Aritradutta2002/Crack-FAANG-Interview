import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
public class TwoArrays {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int n=Integer.parseInt(t1.nextToken());
            int q=Integer.parseInt(t1.nextToken());
            StringTokenizer t2=new StringTokenizer(r.readLine());
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(t2.nextToken());
            HashSet<Integer>s1=new HashSet<>();
            boolean s=true;
            int[]pos=new int[n];
            for(int i=0;i<n;i++)
                if(array[i]==q/2&&q%2==0){
                    if(s)
                        pos[i]=1;
                    s=!s;
                    }
                else
                    if(s1.contains(q-array[i]))
                        pos[i]=1;
                    else
                        s1.add(array[i]);
            for(int i:pos)
                System.out.print(i+" ");
            System.out.println();

        } 
    } 
}
