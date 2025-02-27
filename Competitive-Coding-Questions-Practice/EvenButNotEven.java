import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenButNotEven {
    public static void main(String[] args)throws IOException {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            r.readLine();
            String s=r.readLine();
            int start=-1,end=-1;
            for(int i=0;i<s.length();i++){
                if(Integer.parseInt(Character.toString(s.charAt(i)))%2==1){
                    if(start==-1)
                        start=i;
                    else{
                        end=i;
                        break;
                    }
                }
            }
            if(start==-1||end==-1)
                System.out.println(-1);
            else if(start==0&&end==s.length()-1)
                System.out.println(s);
            else{
                for(int i=start;i<=end;i++)
                    System.out.print(s.charAt(i));
                System.out.println();
            }
        }
        
    }
}