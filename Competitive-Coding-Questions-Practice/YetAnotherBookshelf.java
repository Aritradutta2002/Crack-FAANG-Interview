import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class YetAnotherBookshelf {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(t1.nextToken());
            ArrayList<Integer>list=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(array[i]!=1)
                    continue;
                int count=0;
                for(int j=i+1;j<n;j++){
                    if(array[j]==1){
                        if(count!=0)
                            list.add(count);
                        break;
                    }
                    else
                        count++;
                }
            }
            long sum=0;
            for(int i:list)
                sum+=i;
            // System.out.println(list);
            System.out.println(sum);
        } 
    } 
}
