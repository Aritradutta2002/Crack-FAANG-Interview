import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class NumberGame {
    static boolean hasOdd(int n){
        while(n%2==0)
            n/=2;
        return n!=1;
    }
    static boolean isPrime(int n){
        for(int i=3;i<=(int)Math.sqrt((double)n);i+=2)
            if(n%i==0)
                return false;
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            if(n==1)
                System.out.println("FastestFinger");
            else if(n%2==1)
                System.out.println("Ashishgup");
            else if(n%4==0)
                if(hasOdd(n))
                    System.out.println("Ashishgup");
                else
                    System.out.println("FastestFinger");
            else
                if(n==2)
                    System.out.println("Ashishgup");
                else
                    if(isPrime(n))
                        System.out.println("FastestFinger");
                    else
                        System.out.println("Ashishgup");
        } 
    } 
}