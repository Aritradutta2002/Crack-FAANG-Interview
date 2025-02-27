import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveAdjacent {
    public static void main(String[] args)throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        String s=r.readLine();
        int count=0;
        if(n==1){
            System.out.println(0);
            return ;
        }
        while(true){
            char largest=Character.MIN_VALUE;
            int pos=-1;
            for(int i=0;i<s.length();i++){
                boolean found=false;
                char current=s.charAt(i);
                if(i==0||i==s.length()-1){
                    char compare;
                    if(i==0)
                        compare=s.charAt(i+1);
                    else
                        compare=s.charAt(i-1);
                    if(compare==current-1)
                        found=true;
                }
                else{
                    char compare1=s.charAt(i-1);
                    char compare2=s.charAt(i+1);
                    if(compare1==current-1||compare2==current-1)
                        found=true;
                }
                if(found&&current>largest){
                    pos=i;
                    largest=current;
                }
            }
            if(-1==pos)
                break;
            StringBuilder b=new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(i!=pos)
                    b.append(s.charAt(i));
            }
            s=b.toString();
            count++;
            if(s.length()==1)
                break;
        }
        System.out.println(count);
        
    }
    
}