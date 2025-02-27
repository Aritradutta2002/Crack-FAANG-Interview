import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class GameWithArray {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String[]data=r.readLine().split(" ");
        int n=Integer.parseInt(data[0]);
        int s=Integer.parseInt(data[1]);
        int min=n-1;
        int max=s-min;
        if(min>=max-1)
            System.out.println("NO");
        else{
            System.out.println("YES");
            StringBuilder b=new StringBuilder();
            for(int i=0;i<n-1;i++)
                b.append("1 ");
            b.append(max);
            System.out.println(b.toString());
            System.out.println(max-1);
        }
    } 
}
