import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeItGood {
    public static void main(String[]args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            r.readLine();
            String[]s=r.readLine().split(" ");
            long []array=new long[s.length];
            for(int i=0;i<s.length;i++){
                array[i]=Long.parseLong(s[i]);
            }
            boolean c=true;
            //true=increasing
            int pos=0;
            long last=Long.MIN_VALUE;
            for(int i=array.length-1;i>=0;i--){
                if(c&&array[i]<last){
                    c=false;
                }
                else if(!c&&array[i]>last){
                    pos=i+1;
                    break;
                }
                last=array[i];
            }
            System.out.println(pos);
        }
    }
    
}