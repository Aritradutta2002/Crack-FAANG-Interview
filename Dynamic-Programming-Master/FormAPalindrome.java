import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class FormAPalindrome {
    static int[][]memory;
    static int getMinimum(String s,int left,int right){
        if(left>=right)
            return 0;
        if(memory[left][right]!=-1)
            return memory[left][right];
        if(s.charAt(left)==s.charAt(right))
            return memory[left][right]=getMinimum(s, left+1, right-1);
        return memory[left][right]=Math.min(getMinimum(s, left+1, right), getMinimum(s, left, right-1))+1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String s=r.readLine();
            int n=s.length();
            memory=new int[n][n];
            for(int[]a:memory)
                Arrays.fill(a, -1);
            System.out.println(getMinimum(s, 0, n-1));
        } 
    } 
}