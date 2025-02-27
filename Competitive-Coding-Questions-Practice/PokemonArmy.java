import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class PokemonArmy {
    static long getMin(int[]array,int n,int start){
        long[][]dp=new long[n][2];
        
        if(start==0){
            for(long[]a:dp)
                Arrays.fill(a, Integer.MIN_VALUE);
            dp[0][0]=0;
            dp[0][1]=0;
        }
        for(int i=start;i<n-1;i++){
            dp[i+1][0]=Math.max(dp[i][0], dp[i][1]+array[i]);
            dp[i+1][1]=Math.max(dp[i][1], dp[i][0]-array[i]);
        }
        dp[n-1][1]+=Math.max(array[n-1], 0);
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data1=r.readLine().split(" ");
            int n=Integer.parseInt(data1[0]);
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            int q=Integer.parseInt(data1[1]);
            for(int i=0;i<n;i++){
                array[i]=Integer.parseInt(data[i]);
            }
            System.out.println(getMin(array, n,0));
            while(q-->0){
                String[]d=r.readLine().split(" ");
                int pos1=Integer.parseInt(d[0])-1;
                int pos2=Integer.parseInt(d[1])-1;
                int temp=array[pos1];
                array[pos1]=array[pos2];
                array[pos2]=temp;
                System.out.println(getMin(array, n,Math.max(Math.min(pos1, pos2)-1, 0)));
            }
        }
    } 
}
