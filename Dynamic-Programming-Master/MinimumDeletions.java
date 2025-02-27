import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class MinimumDeletions {
    static int[][]memory;
    static int minDeletions(String s,int ptr1,int ptr2){
        if(ptr1>=ptr2)
            return 0;
        if(s.charAt(ptr1)==s.charAt(ptr2))
            return minDeletions(s, ptr1+1, ptr2-1);
        if(memory[ptr1][ptr2]!=-1)
            return memory[ptr1][ptr2];
        int n1=minDeletions(s, ptr1+1, ptr2)+1;
        int n2=minDeletions(s, ptr1, ptr2-1)+1;
        int n3=minDeletions(s, ptr1+1, ptr2-1)+2;
        return memory[ptr1][ptr2]=Math.min(Math.min(n1, n2), Math.min(n2, n3));
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String s=r.readLine();
            int n=s.length();
            memory=new int[n+1][n+1];
            for(int[]a:memory)
                Arrays.fill(a, -1);
            System.out.println(minDeletions(s, 0, n-1));
        }
    } 
}