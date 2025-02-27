import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class donutShop {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data=r.readLine().split(" ");
            int p1=Integer.parseInt(data[0]);
            int p2=Integer.parseInt(data[2]);
            int q2=Integer.parseInt(data[1]);
            String s="";
            if(p2>p1)
                s+="1";
            else
                s+="-1";
            s+=" ";
            if((long)p1*(long)q2>(long)p2)
                s+=Integer.toString(q2);
            else
                s+="-1";
            System.out.println(s);
        } 
    } 
}