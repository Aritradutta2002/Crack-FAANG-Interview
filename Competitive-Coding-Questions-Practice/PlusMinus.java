import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class PlusMinus {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String s=r.readLine();
            int max=0;
            int n=s.length();
            int count=0;
            int[]array=new int[n];
            for(int i=1;i<n;i++)
                if(s.charAt(i)=='+')
                    array[i]=array[i-1]+1;
                else
                    array[i]=array[i-1];

            for(int i=0;i<n;i++){
                if(s.charAt(i)=='+')
                    count--;
                else
                    count++;
                max=Math.max(max, count);
            }
            max++;
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=max;
                if(max!=1)
                    sum+=array[i]*2;
                if(s.charAt(i)=='-'&&max>1)
                    max--;
            }
            System.out.println(sum);
        } 

    } 
}