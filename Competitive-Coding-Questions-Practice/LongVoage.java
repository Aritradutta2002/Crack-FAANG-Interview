import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongVoage {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            int eights=n/4;
            int zeros=n%4;
            int left=n*4-n-(4-zeros);
            left=left/4;
            for(int i=0;i<left;i++)
                System.out.print(9);
            if(zeros==0)
                System.out.print(9);
            for(int i=0;i<eights;i++)
                System.out.print(8);
            if(zeros!=0)
                System.out.print(8);
            System.out.println();
            
        }
        
    }
}