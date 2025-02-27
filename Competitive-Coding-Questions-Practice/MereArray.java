import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class MereArray {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            int[]old=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            int min=Integer.MAX_VALUE;
            for(int i:array)
                min=Integer.min(i, min);
            for(int i=0;i<n;i++)
                old[i]=array[i];
            Arrays.sort(array);
            boolean isPossible=true;
            for(int i=0;i<n;i++){
                if(array[i]!=old[i])
                    if(old[i]%min!=0){
                        isPossible=false;
                        break;
                    }
            }
            if(isPossible)
                System.out.println("YES");
            else
                System.out.println("NO");
            
        } 
    } 
}