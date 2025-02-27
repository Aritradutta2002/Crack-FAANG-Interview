import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class KcompleteWord {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int n=Integer.parseInt(t1.nextToken());
            int k=Integer.parseInt(t1.nextToken());
            String s=r.readLine().trim();
            int ans=0;
            for(int i=0;i<=k/2-(1-k%2);i++){
                int count=0;
                int[]array=new int[27];
                for(int j=i;j<n;j+=k){
                    array[s.charAt(j)%26]++;
                    count++;
                    // System.out.println(j);
                }
                for(int j=k-i-1;j<n;j+=k){
                    // System.out.println(j);
                    array[s.charAt(j)%26]++;
                    count++;
                }
                int max=Integer.MIN_VALUE;
                // System.out.println("count="+count);
                for(int j:array)
                    max=Math.max(j, max);
                count-=max;
                if(i==k-i-1)
                    count/=2;
                    // System.out.println("max="+max);
                // System.out.println(i+" "+count);
                
                
                ans+=count;
            }
            System.out.println(ans);
        }
    } 
}
