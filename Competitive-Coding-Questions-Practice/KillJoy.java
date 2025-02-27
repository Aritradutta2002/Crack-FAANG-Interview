import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class KillJoy {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t2=new StringTokenizer(r.readLine());
            int n=Integer.parseInt(t2.nextToken());
            int x=Integer.parseInt(t2.nextToken());
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(t1.nextToken());
            boolean isSame=true;
            for(int i:array)
                if(i!=x){
                    isSame=false;
                    break;
                }
            boolean contains=false;
            for(int i:array)
                if(i==x){
                    contains=true;
                    break;
                }
            
            if(isSame){
                System.out.println(0);
                continue;
            }
            if(contains){
                System.out.println(1);
                continue;
            }
            int sum=0;
            for(int i:array)
                sum+=(x-i);
            if(sum==0){
                System.out.println(1);
                continue;
            }
            System.out.println(2);

        } 
    } 
}
