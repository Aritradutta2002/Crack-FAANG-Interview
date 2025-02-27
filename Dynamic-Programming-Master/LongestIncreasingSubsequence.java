import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            int []memory=new int[n];
            Arrays.fill(memory, 1);
            for(int i=0;i<n;i++)
                for(int j=0;j<i;j++){
                    if(array[i]>array[j])
                        memory[i]=Math.max(memory[i], memory[j]+1);
                }
            int max=Integer.MIN_VALUE;
            for(int i:memory)
                max=Math.max(i, max);
            System.out.println(max);
        } 
    } 
}