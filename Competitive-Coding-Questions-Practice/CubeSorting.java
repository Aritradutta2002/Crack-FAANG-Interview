import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class CubeSorting {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            int[]cpy=new int[n];
            for(int i=0;i<n;i++){
                array[i]=Integer.parseInt(data[i]);
                cpy[i]=array[i];
            }
            int count=0;
            Arrays.sort(cpy);
            for(int i=0;i<n;i++){
                int j=n-i-1;
                if(array[i]==cpy[j])
                    count++;
            }
            boolean isSame=false;
            for(int i=1;i<n;i++)
                if(cpy[i]==cpy[i-1]){
                    isSame=true;
                    break;
                }
            if(count==n&&!isSame)
                System.out.println("NO");
            else
                System.out.println("YES");
        } 
    } 
}
