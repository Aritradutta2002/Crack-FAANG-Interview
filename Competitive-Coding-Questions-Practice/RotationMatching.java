import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class RotationMatching {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        String [] s1=r.readLine().split(" ");
        String [] s2=r.readLine().split(" ");
        int [] array=new int[n];
        int [] pos=new int[n];
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(s1[i]);
        for(int i=0;i<n;i++)
            pos[Integer.parseInt(s2[i])-1]=i;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int diff=pos[array[i]-1]-i;
            if(diff<0)
                diff=n+diff;
            if(map.containsKey(diff))
                map.replace(diff,map.get(diff)+1);
            else
                map.put(diff,1);
        }
        int max=Integer.MIN_VALUE;
        for(int key:map.keySet())
            if(map.get(key)>max)
                max=map.get(key);
        System.out.println(max);
    } 
}