import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class SkipTheWork {
    static int minWork(int[]array){
        int[][]memory=new int[array.length][2];
        for(int[]a:memory)
            Arrays.fill(a,Integer.MAX_VALUE);
        memory[0][0]=0;
        memory[0][1]=array[0];
        for(int i=1;i<array.length;i++){
            memory[i][0]=Math.min(memory[i][0],memory[i-1][1]);
            memory[i][1]=Math.min(memory[i][1],memory[i-1][1]+array[i]);
            memory[i][1]=Math.min(memory[i][1],memory[i-1][0]+array[i]);
        }
        return Math.min(memory[array.length-1][0], memory[array.length-1][1]);
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
            System.out.println(minWork(array));
        }
    } 
}