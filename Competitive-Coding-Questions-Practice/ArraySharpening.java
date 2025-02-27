import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArraySharpening {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++){
                array[i]=Integer.parseInt(data[i]);
            }
            int pos;
            int current=0;
            for(pos=0;pos<n;pos++){
                if(array[pos]<current)
                    break;
                current++;
            }
            boolean isPossible=true;
            current=0;
            for(int i=n-1;i>=pos-1;i--){
                if(array[i]<current){
                    isPossible=false;
                    break;
                }
                current++;
            }
            if(isPossible)
                System.out.println("YES");
            else
                System.out.println("NO");

        
        }   
    }
}