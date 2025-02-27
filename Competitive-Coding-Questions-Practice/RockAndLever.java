import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class RockAndLever {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String []data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            int[]size=new int[n];
            for(int i=0;i<n;i++)
                size[i]=Integer.toBinaryString(array[i]).trim().length();
            int max=0;
            for(int i:size)
                max=Math.max(i, max);
            int []freq=new int[max+1];
            for(int i:size)
                freq[i]++;
            long sum=0;
            for(int i:freq){
                int n1=i-1;
                int n2=i;
                if(n1%2==0)
                    n1/=2;
                else
                    n2/=2;

                long add=n1*n2;
                sum+=add;
            }
            System.out.println(sum);


        }
    } 
}
