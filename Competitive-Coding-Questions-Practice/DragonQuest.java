import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class DragonQuest {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            int x=Integer.parseInt(data[0]);
            int n=Integer.parseInt(data[1]);
            int m=Integer.parseInt(data[2]);
            while(n>0&&x>20){
                n--;
                x=x/2+10;
            }
            while(m>0){
                m--;
                x-=10;
            }
            if(x>0)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    } 
}