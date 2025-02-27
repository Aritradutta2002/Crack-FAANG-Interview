import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PairwiseMax {
    public static void main(String[]args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            long n1=Long.parseLong(data[0]);
            long n2=Long.parseLong(data[1]);
            long n3=Long.parseLong(data[2]);
            boolean b=true;
            
            if(((n1==n2&&n3<=n1)||(n1==n3&&n2<=n1)||(n3==n2&&n1<=n2))&&b){
                System.out.println("YES");
                if(n1==n2)
                    System.out.println(n3+" "+n1+" "+n3);
                else if(n2==n3)
                    System.out.println(n1+" "+n1+" "+n2);
                else if(n1==n3)
                    System.out.println(n1+" "+n2+" "+1);
            }
            else{
                System.out.println("NO");
            }
        }
    }
    
}