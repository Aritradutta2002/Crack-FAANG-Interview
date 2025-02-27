import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class dDistrictsConnection {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            int[]array=new int[n];
            StringTokenizer t1=new StringTokenizer(r.readLine());
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(t1.nextToken());
            int n1=array[0];
            boolean isSame=true;
            for(int i=1;i<n;i++)
                if(array[i]!=n1){
                    isSame=false;
                    break;
                }
            if(isSame){
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
            for(int i=1;i<n;i++){
                for(int j=0;j<n;j++){
                    if(array[j]!=array[i]){
                        System.out.println((i+1)+" "+(j+1));
                        break;
                    }
                }
            }
        }
    } 
}
