import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MindControl {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            int n=Integer.parseInt(data[0]);
            int m=Integer.parseInt(data[1]);
            int k=Integer.parseInt(data[2]);
            if(k>m-1){
                k=m-1;
            }
            String[]s=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++){
                array[i]=Integer.parseInt(s[i]);
            }
            int ans = Integer.MIN_VALUE;
            for(int start = 0; start + n - m + Math.min(k, m) <= n; start ++){
                int end = start + Math.max(m - k, 0);
                // System.out.println(start + " " + end);
                int diff = Math.max(0, m - k);
                int min = Integer.MAX_VALUE;
                for(int i = start; i < start + diff; i ++){
                    min = Math.min(min, array[i]);
                    // System.out.println(i);
                }
                for(int i = end - diff; i < end; i ++ ){
                    min = Math.min(min, array[i]);
                    // System.out.println(i);
                }
                // System.out.println("!!!!!!!!");
                System.out.println(min);
                ans = Math.max(ans, min);
            }

            System.out.println(ans + " !!!");

        }
        
    }
}