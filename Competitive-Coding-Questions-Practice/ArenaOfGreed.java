import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ArenaOfGreed {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1=Integer.parseInt(r.readLine());
        while(t1-->0){
            long n=Long.parseLong(r.readLine());
            long count=0;
            boolean check=true;
            while(n!=0){
                if(n%2==1){
                    n--;
                    count+=(check)?1:0;
                }
                else if((n/2)%2==0&&n!=4){
                    count+=(check)?1:0;
                    n--;
                }
                else{
                    count+=(check)?n/2:0;
                    n/=2;
                }
                check=!check;
            }
            System.out.println(count);
        } 
    } 
}
