import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class PositiveAnd {
    static boolean check(long n){ 
        while(n%2==0)
            n/=2;
        return n==1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            try{
                long n=Long.parseLong(r.readLine());
            if(n==0)
                continue;
            if(n==1){
                System.out.println(1);
                continue;
            }
            if(check(n)){
                System.out.println(-1);
                continue;
            }
            if(n==3){
                System.out.println("1 3 2");
                continue;
            }
            StringBuilder b=new StringBuilder();
            b.append("2 3 1 ");
            long start=4;
            long end=Math.min(start*2, n);
            while(end<=n){
                end=Math.min(start*2, n);
                b.append(start+1);
                b.append(" ");
                for(long i=start;i<end;i++){
                    if(i==start+1){
                        continue;
                    }
                    b.append(i);
                    b.append(" ");
                }
                if(end==n){
                    if(end!=start+1){
                        b.append(n);
                    }
                    break;
                }
                start=start*2;
            }
            System.out.println(b.toString());
            }
            catch(Exception e){
                System.out.println(-1);
            }
        } 
    }     
}
