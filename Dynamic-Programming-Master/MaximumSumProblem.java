import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MaximumSumProblem {
    static int[]memory;
    static int getMax(int n){
        if(n<=1)
            return n;
        if(memory[n]!=0)
            return memory[n];
        int sum=getMax(n/2)+getMax(n/3)+getMax(n/4);
        return memory[n]=Integer.max(sum, n);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            memory=new int[n+1];
            System.out.println(getMax(n));
        }
    } 
}