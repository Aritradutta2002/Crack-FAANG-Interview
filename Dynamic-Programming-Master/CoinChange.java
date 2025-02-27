import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinChange {
    static int[][]memory;
    static int getCount(int[]array,int ptr,int current,int n){
        if(current==0)
            return 1;
        if(current<0)
            return 0;
        if(memory[current][ptr]!=-1)
            return memory[current][ptr];
        int count=0;
        for(int i=ptr;i<n;i++)
            count+=getCount(array, i, current-array[i], n);
        return memory[current][ptr]=count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while (t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            int target=Integer.parseInt(r.readLine());
            memory=new int[target+1][n+1];
            for(int[]a:memory)
                Arrays.fill(a, -1);
            int count=getCount(array, 0,target, n);
            System.out.println(count);
        }
    } 
}