import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class DigitGame {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String []data=r.readLine().split("");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            boolean contains=true;
            if(n%2==0){
                for(int i=1;i<n;i+=2){
                    if(array[i]%2==0){
                        contains=false;
                        break;
                    }
                }
            }
            else{
                boolean found=false;
                for(int j=0;j<n;j+=2){
                    if(array[j]%2==1){
                        found=true;
                        break;
                    }
                }
                contains=found;
            }
            if(contains)
                System.out.println(1);
            else
                System.out.println(2);
        }
    } 
}
