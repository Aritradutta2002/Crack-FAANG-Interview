import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class PattyCakes {
    static boolean check(int n,int max,int maxCount,int k){
        boolean []array=new boolean[n];
        int ptr=0;
        for(int i=0;i<maxCount;i++){
            for(int j=0;j<max;j++){
                int pos=ptr+k*j;
                if(pos>=n)
                    return false;
                if(array[pos])
                    return false;
                array[pos]=true;
            }
            ptr++;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            HashMap<Integer,Integer>map=new HashMap<>();
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            for(int i:array)
                if(map.containsKey(i))
                    map.replace(i,map.get(i)+1);
                else
                    map.put(i, 1);
            int max=0,maxCount=0;
            for(int key:map.keySet())
                max=Math.max(max, map.get(key));
            for(int key:map.keySet())
                if(map.get(key)==max)
                    maxCount++;
            int low=0;
            int high=n;
            int ans=0;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(check(n, max, maxCount, mid)){
                    ans=mid;
                    low=mid+1;
                }
                else
                    high=mid-1;
            }
            if(ans!=0)
                ans--;
            System.out.println(ans);

            
        }
    } 
}