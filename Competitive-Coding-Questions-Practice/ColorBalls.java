import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorBalls {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            int even=0,odd=0;
            boolean isZero=false;
            for(int i=0;i<3;i++){
                int num=Integer.parseInt(data[i]);
                if(num==0)
                    isZero=true;
                if(num%2==0)
                    even++;
                else
                    odd++;
            }
            int last=Integer.parseInt(data[3]);
            boolean b=false;
            if(even==3||odd==3)
                b=true;
            else if(even==2&&last%2==0)
                b=true;
            else if(odd==2&&last%2==1&&!isZero)
                b=true;
            if(b)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}