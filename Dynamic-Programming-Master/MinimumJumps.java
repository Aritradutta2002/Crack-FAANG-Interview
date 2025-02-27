import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class MinimumJumps {
    static int[]memory;
    static int getMinimumSteps(int[]array,int pos,int n){
        if(pos>=n-1)
            return 0;
        if(memory[pos]!=-1)
            return memory[pos];
        int min=Integer.MAX_VALUE-500;
        for(int i=1;i<=array[pos];i++)
            min=Math.min(min, getMinimumSteps(array, pos+i, n)+1);
        return memory[pos]=min;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            memory=new int[n];
            Arrays.fill(memory, -1);
            int ans=getMinimumSteps(array, 0, n);
            if(ans>=Integer.MAX_VALUE-500)
                ans=-1;
            System.out.println(ans);
        }
    } 
}