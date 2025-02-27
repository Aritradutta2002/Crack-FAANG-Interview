import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Ahahahahahahahaha {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int zcount=0,ocount=0;
            for(String s:data)
                if(s.equals("1"))
                    ocount++;
                else
                    zcount++;
            
            int count=Math.max(zcount, ocount);
            if(ocount>zcount)
                count=count-count%2;
            System.out.println(count);
            for(int i=0;i<count;i++)
                if(ocount>zcount)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            System.out.println();
        } 
    } 
}
