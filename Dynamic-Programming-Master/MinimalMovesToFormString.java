import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class MinimalMovesToFormString{
    static int getMiniumum(String s){
        int n=s.length();
        int[]memory=new int[n];
        Arrays.fill(memory,Integer.MAX_VALUE);
        memory[0]=1;
        String completed="";
        completed+=s.charAt(0);
        for(int i=1;i<n;i++){
            memory[i]=Integer.min(memory[i],memory[i-1]+1);
            completed+=s.charAt(i);
            if(2*i+2<=n)
                if(completed.equals(s.substring(i+1,2*i+2)))
                    memory[2*i+1]=Integer.min(memory[i]+1,memory[2*i+1]);
        }
        return memory[n-1];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0)
            System.out.println(getMiniumum(r.readLine()));
    } 
}