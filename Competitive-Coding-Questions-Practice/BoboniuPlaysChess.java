import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoboniuPlaysChess {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String[]data=r.readLine().split(" ");
        int m=Integer.parseInt(data[0]);
        int n=Integer.parseInt(data[1]);
        int x=Integer.parseInt(data[2]);
        int y=Integer.parseInt(data[3]);
        System.out.println(x+" "+y);
        for(int i=1;i<=n;i++){
            if(i!=y)
                System.out.println(x+" "+i);
        }
        y=n;
        for(int i=1;i<=m;i++){
            if(i==x)
                continue;
            if(y==n){
                for(int j=n;j>=1;j--)
                    System.out.println(i+" "+j);
                y=1;
            }
            else{
                for(int j=1;j<=n;j++)
                    System.out.println(i+" "+j);
                y=n;
            }
        }


    }
    
}