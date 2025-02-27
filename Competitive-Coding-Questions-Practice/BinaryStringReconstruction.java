import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BinaryStringReconstruction {
    static boolean isPossible(int pos,int n){
        return pos>=0&&pos<n;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int one,two,zero;
            zero=Integer.parseInt(t1.nextToken());
            one=Integer.parseInt(t1.nextToken());
            two=Integer.parseInt(t1.nextToken());
            
            StringBuilder b=new StringBuilder();
            if(one==0&&two==0){
                for(int i=0;i<zero+1;i++){
                    b.append(0);
                }
                System.out.println(b);
                continue;
            }
            for(int i=0;i<two+1;i++)
                b.append(1);
            if(one!=0)
                b.append(0);
            for(int i=0;i<one/2-(1-one%2);i++)
                b.append("10");
            for(int i=0;i<zero;i++)
                b.append(0);
            if(one%2==0&&one!=0)
                System.out.print(0);
            System.out.print(b);
            System.out.println();
        } 
    } 
}