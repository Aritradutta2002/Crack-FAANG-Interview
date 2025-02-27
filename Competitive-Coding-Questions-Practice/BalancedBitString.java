import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class BalancedBitString {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]d=r.readLine().split(" ");
            int n=Integer.parseInt(d[0]);
            int k=Integer.parseInt(d[1]);
            String s=r.readLine().trim();
            char[]array=new char[k];
            Arrays.fill(array, '?');
            int ptr=0;
            boolean check=true;
            for(int i=0;i<n;i++){
                char c=s.charAt(i);
                // System.out.println(c);
                if(c=='?'){
                    ptr=(ptr+1)%k;
                    continue;
                }
                else if(array[ptr]=='?')
                    array[ptr]=c;
                else if(array[ptr]!=c){
                    check=false;
                    break;
                }
                // for(char b:array)
                //     System.out.print(b+" ");
                // System.out.println(check);
                ptr=(ptr+1)%k;
            }
            int zcount=0,ocount=0;
            for(char c:array)
                if(c=='1')
                    ocount++;
                else if(c=='0')
                    zcount++;
            
            check=check&&(Math.abs(zcount-ocount)<=(k-(zcount+ocount)));
            if(check)
                System.out.println("YES");
            else
                System.out.println("NO");
        } 
    } 
}
