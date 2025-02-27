import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Knapsack {
    static int[][]memory;
    static int getMax(int[]array,int[]weights,int w,int ptr,int currentWt,int n){
        if(ptr>=n)
            return 0;
        if(currentWt>=w)
            return 0;
        if(memory[ptr][currentWt]!=-1)
            return memory[ptr][currentWt];
        if(weights[ptr]+currentWt>w)
            return memory[ptr][currentWt]=getMax(array, weights, w, ptr+1, currentWt, n);
        else
            return memory[ptr][currentWt]=Math.max(getMax(array, weights, w, ptr+1, currentWt+weights[ptr], n)+array[ptr],getMax(array, weights, w, ptr+1, currentWt, n));
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            int w=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            String[]data2=r.readLine().split(" ");
            int[]array=new int[n];
            int[]weights=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            for(int i=0;i<n;i++)
                weights[i]=Integer.parseInt(data2[i]);
            memory=new int[n+1][w+1];
            for(int[]a:memory)
                Arrays.fill(a, -1);
            System.out.println(getMax(array, weights, w, 0, 0, n));
        }
    } 
}