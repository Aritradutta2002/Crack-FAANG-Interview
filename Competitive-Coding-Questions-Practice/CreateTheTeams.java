import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class CreateTheTeams {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]ll=r.readLine().split(" ");
            int n=Integer.parseInt(ll[0]);
            int min=Integer.parseInt(ll[1]);
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            Arrays.sort(array);
            int current=0;
            int count=0;
            for(int i=n-1;i>=0;i--){
                int num=array[i];
                current++;
                if(num*current>=min){
                    current=0;
                    count++;
                }
            }
            System.out.println(count);
        } 
    } 
}