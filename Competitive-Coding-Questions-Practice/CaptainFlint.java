import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaptainFlint {
    public static void main(String[] args)throws IOException{
        BufferedReader r=new BufferedReader (new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            if(n<=30)
                System.out.println("NO");
            else{
                int diff=n-6-10-14;
                if(diff!=6&&diff!=10&&diff!=14){
                    System.out.println("YES");
                    System.out.println("6 10 14 "+(n-6-10-14));
                }
                else{
                    if(n<=31){
                        System.out.println("NO");
                    }
                    else{
                        System.out.println("YES");
                        System.out.println("6 10 15 "+(n-6-10-15));
                    }
                }
            }
        }
    }
    
}