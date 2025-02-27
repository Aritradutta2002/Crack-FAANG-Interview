import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class ZeroRemainderArray {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]ll=r.readLine().split(" ");
            int n=Integer.parseInt(ll[0]);
            int num=Integer.parseInt(ll[1]);
            String[]data=r.readLine().split(" ");
            HashMap<Integer,Long>map=new HashMap<>();
            for(String i:data){
                int remainder=num-Integer.parseInt(i)%num;
                if(remainder!=num)
                    if(map.containsKey(remainder))
                        map.replace(remainder,map.get(remainder)+num);
                    else
                        map.put(remainder,(long)remainder+1);
            }
            long max=0;
            for(int i:map.keySet())
                max=Math.max(max,map.get(i));
            System.out.println(max);
        }
    } 
}