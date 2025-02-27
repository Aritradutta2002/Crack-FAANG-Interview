import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class TernarySequence {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data1=r.readLine().split(" ");
            String[]data2=r.readLine().split(" ");
            int a2=Integer.parseInt(data1[2]);
            int a1=Integer.parseInt(data1[1]);
            int a0=Integer.parseInt(data1[0]);
            int b2=Integer.parseInt(data2[2]);
            int b1=Integer.parseInt(data2[1]);
            int b0=Integer.parseInt(data2[0]);
            b2=Math.max(0, b2-a0);
            if(b2<=a2){
                if(b2>0)
                    a2-=b2;
                System.out.println(Math.min(a2, b1)*2);
            }
            else{

                b2-=a2;
                if(b2<=0)
                    System.out.println(0);
                else
                    System.out.println(b2*-2);
            }


        }
    } 
}