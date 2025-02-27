import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class ArraysSum {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int n=Integer.parseInt(t1.nextToken());
            int k=Integer.parseInt(t1.nextToken());
            t1=new StringTokenizer(r.readLine());
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(t1.nextToken());
            int ans=1;
            int l=k;
            int current=0;
            int last=array[0];
            boolean first=true;
            for(int i:array){
                if(i!=last){
                    current++;
                    last=i;
                }
                if(current==k){
                    current=0;
                    ans++;
                    if(first){
                        k--;
                        first=false;
                    }
                }
            }
            int diffvalue=1;
            last=array[0];
            for(int i:array)
                if(i!=last){
                    diffvalue++;
                    last=i;
                }
            if(l==1&&diffvalue>1){
                System.out.println(-1);
                continue;
            }
            System.out.println(ans);
        } 
    } 
}
