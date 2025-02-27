import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class KFoldableString {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]ss=r.readLine().split(" ");
            int n=Integer.parseInt(ss[0]);
            int k=Integer.parseInt(ss[1]);
            String s=r.readLine().trim();
            int zero=0,one=0;
            for(int i=0;i<n;i++)
                if(s.charAt(i)=='1')
                    one++;
                else
                    zero++;
            if(k==1){
                if(zero==0||k==0)
                    System.out.println(s);
                else
                    System.out.println("IMPOSSIBLE");
            }
            else if(k==n){
                StringBuilder b=new StringBuilder();
                while(zero-->0)
                    b.append("0");
                while(one-->0)
                    b.append("1");
                System.out.println(b.toString());
            }
            else if((zero)%(n/k)==0&&(one)%(n/k)==0){
                int z=zero/(n/k);
                int o=one/(n/k);
                StringBuilder b=new StringBuilder();
                while(z-->0)
                    b.append("0");
                while(o-->0)
                    b.append("1");
                String st=b.toString();
                String rev=b.reverse().toString();
                boolean dir=true;
                String ans="";
                for(int i=0;i<n/k;i++){
                    if(dir)
                        ans+=st;
                    else
                        ans+=rev;
                    dir=!dir;
                }
                System.out.println(ans);
            }
            else
                System.out.println("IMPOSSIBLE");
                
                
        }
    } 
}