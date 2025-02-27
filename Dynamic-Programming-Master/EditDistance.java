import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class EditDistance {
    static int[][]memory;
    static int getMinimum(String s1,String s2,int ptr1,int ptr2,int m,int n){
        if(ptr2>=n&&ptr1>=m)
            return 0;
        if(ptr1>=m)
            return n-ptr2;
        if(ptr2>=n)
            return m-ptr1;
        if(memory[ptr1][ptr2]!=-1)
            return memory[ptr1][ptr2];
        int r1=getMinimum(s1, s2, ptr1+1, ptr2, m, n)+1;
        int r2=getMinimum(s1, s2, ptr1, ptr2+1, m, n)+1;
        int r3=getMinimum(s1, s2, ptr1+1, ptr2+1, m, n)+1;
        if(s1.charAt(ptr1)==s2.charAt(ptr2))
            r3--;
        return memory[ptr1][ptr2]=Math.min(Math.min(r1, r2), Math.min(r2, r3));
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            int m=Integer.parseInt(data[0]);
            int n=Integer.parseInt(data[1]);
            String[]s=r.readLine().split(" ");
            String s1=s[0].trim();
            String s2=s[1].trim();
            memory=new int[m+1][n+1];
            for(int[]a:memory)
                Arrays.fill(a, -1);
            System.out.println(getMinimum(s1, s2, 0, 0, m, n));
        } 
    } 
}