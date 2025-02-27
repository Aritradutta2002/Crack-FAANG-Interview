import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Robots{
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        String []s1=r.readLine().split(" ");
        String[]s2=r.readLine().split(" ");
        int c1=0,c2=0;
        for(int i=0;i<n;i++){
            int n1=Integer.parseInt(s1[i]);
            int n2=Integer.parseInt(s2[i]);
            if(n1==1&&n2==0)
                c1++;
            else if(n1==0&&n2==1)
                c2++;
        }
        int ans;
        if(c1==0)
            ans=-1;
        else if(c1>c2)
            ans=1;
        else 
            ans=c2/c1+1;
        System.out.println(ans);
            

    }
}