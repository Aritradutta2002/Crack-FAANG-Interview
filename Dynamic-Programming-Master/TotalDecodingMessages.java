import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class TotalDecodingMessages {
    static int[]memory;
    static int getCount(String s,int pos,int n){
        if(pos>=n)
            return 1;
        if(s.charAt(pos)=='0')
            return -1;
        if(pos==n-1)
            return 1;
        if(memory[pos]!=-1)
            return memory[pos];
        int count=0;
        int val=getCount(s, pos+1, n);
        if(val!=-1)
            count+=(val);
        if(Integer.parseInt(s.subSequence(pos, pos+2).toString())<=26){
            val=getCount(s, pos+2, n);
            if(val!=-1)
                count+=(val);
        }
        return memory[pos]=count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String s=r.readLine();
            memory=new int[n+1];
            Arrays.fill(memory, -1);
            int ans=getCount(s, 0, n);
            if(ans==-1)
                ans=0;
            System.out.println(ans);

        } 
    } 
}