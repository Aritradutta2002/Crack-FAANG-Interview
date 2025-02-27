import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Chat {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t=new StringTokenizer(r.readLine());
        int n=Integer.parseInt(t.nextToken());
        int k=Integer.parseInt(t.nextToken());
        t=new StringTokenizer(r.readLine());
        int[]array=new int[n];
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(t.nextToken())-1;
        int []ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]+=1;
            ans[i]+=i-Math.max(0, i-k);
            ans[i]+=Math.min(n-1, i+k)-i;
            if(array[i]!=-1){
                ans[i]+=ans[array[i]];
                int end=Math.min(n-1, array[i]+k);
                ans[i]-=Math.max(0, (end - Math.max(0, i-k))+1);
            }
        }
        for(int i:ans)
            System.out.print(i+" ");
        System.out.println();

        
    } 
}
