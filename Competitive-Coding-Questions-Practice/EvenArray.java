import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class EvenArray {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            int even=0,odd=0;
            for(int i=0;i<n;i++)
                if(i%2!=array[i]%2)
                    if(i%2==0)
                        even++;
                    else
                        odd++;
            if(even==odd)
                System.out.println(even);
            else
                System.out.println(-1);
        } 
    } 
}
