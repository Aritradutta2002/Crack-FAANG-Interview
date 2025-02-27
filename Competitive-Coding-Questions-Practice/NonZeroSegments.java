import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
public class NonZeroSegments {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        StringTokenizer t=new StringTokenizer(r.readLine());
        int[]array=new int[n];
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(t.nextToken());
        HashMap<Long,Integer>map=new HashMap<>();
        long sum=0;
        int lastPos=-1;
        int count=0;
        map.put(sum, -1);
        for(int i=0;i<n;i++){
            sum+=array[i];
            if(map.containsKey(sum)){
                if(map.get(sum)>=lastPos){
                    count++;
                    lastPos=i-1;
                }
                map.replace(sum, i);
            }
            else
                map.put(sum, i);
        }
        System.out.println(count);



    } 
}
