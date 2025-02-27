import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SwapAdjacentElements {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        StringTokenizer t=new StringTokenizer(r.readLine());
        String s=r.readLine().trim();
        int[]array=new int[n];
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(t.nextToken());
        int till=0;
        for(int i=0;i<n;i++){
            if(array[i]-1<till){
                System.out.println("NO");
                return;
            }
            if(i==n-1)
                break;
            if(s.charAt(i)=='0')
                till=i+1;
        }
        System.out.println("YES");

    } 
}
