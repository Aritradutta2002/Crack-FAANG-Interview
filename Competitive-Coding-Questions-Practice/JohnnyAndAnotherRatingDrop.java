import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class JohnnyAndAnotherRatingDrop {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            long n=Long.parseLong(r.readLine());
            long num=1;
            while(num<=n){
                num*=2;
            }
            if(num>n)
                num/=2;
            BigInteger count=new BigInteger(Long.toString(num));
            count=count.multiply(new BigInteger("2"));
            count=count.subtract(new BigInteger("1"));
            long diff=n-num;
            long add=(diff/4)*4;
            long n1=diff+2;
            long n2=diff+3;
            if(diff%2==0)
                n1/=2;
            else
                n2/=2;
            add+=(n1*n2)-3;
            if(diff%4==1)
                add+=1;
            else if(diff%4==2)
                add+=3;
            else if(diff%4==3)
                add+=4;
            count=count.add(new BigInteger(Long.toString(add)));
            System.out.println(count);



            

        } 
    } 
}
