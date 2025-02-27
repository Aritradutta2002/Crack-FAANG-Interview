import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class AncientComputer {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            long a=Long.parseLong(data[0]);
            long b=Long.parseLong(data[1]);
            if(a<b){
                long temp=a;
                a=b;
                b=temp;
            }
            if(a%b==0||a==b){
                long fact=a/b;
                int count=0;
                while(true){
                    if(fact%8==0)
                        fact/=8;
                    else if(fact%4==0)
                        fact/=4;
                    else if(fact%2==0)
                        fact/=2;
                    else break;
                    count++;
                }
                if(fact==1)
                    System.out.println(count);
                else
                    System.out.println(-1);
            }
            else
                System.out.println(-1);
        } 
    } 
}