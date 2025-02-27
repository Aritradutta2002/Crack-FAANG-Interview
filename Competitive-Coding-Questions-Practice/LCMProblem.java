import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCMProblem {
    public static void main(String[] args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            int low=Integer.parseInt(data[0]);
            int high=Integer.parseInt(data[1]);
            if(low>high/2)
                System.out.println("-1 -1");
            else{
                int num2=-1;
                for(int i=low;i<=high/2+10;i++){
                    if(high%i==0){
                        num2=i;
                        break;
                    }
                }
                if(num2==-1)
                    System.out.println("-1 -1");
                else{
                    if(high==num2){
                        System.out.println(-1+" "+-1);

                    }
                    else{
                        System.out.println(num2+" "+high);

                    }
                }            }
        }

    }
}