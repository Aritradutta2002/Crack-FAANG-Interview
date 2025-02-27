import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class Barrels2 {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int n=Integer.parseInt(t1.nextToken());
            int k=Integer.parseInt(t1.nextToken());
            t1=new StringTokenizer(r.readLine());
            ArrayList<Integer>list=new ArrayList<>();
            for(int i=0;i<n;i++)
                list.add(Integer.parseInt(t1.nextToken()));
            Collections.sort(list);
            long sum=0;
            for(int i=n-1;i>=0&&k>=0;i--){
                sum+=list.get(i);
                k--;
            }
            System.out.println(sum);
        }
    } 
}
