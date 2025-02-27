import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class SillyMistake {
    private static boolean check(int[]array,int start,int end){
        int[]freq=new int [1000002];
        for(int i=start;i<=end;i++)
            if((array[i]<0&&freq[Math.abs(array[i])]==0) || freq[Math.abs(array[i])]>=2)
                return false;
            else
                freq[Math.abs(array[i])]++;

        for(int i=start;i<=end;i++)
            if(freq[Math.abs(array[i])]!=2)
                return false;

        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        int[]array=new int[n];
        StringTokenizer t=new StringTokenizer(r.readLine());
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(t.nextToken());
        int last=0;
        long sum=0;
        ArrayList<Integer>list=new ArrayList<>();
        list.add(0);
        for(int i=0;i<n;i++){
            sum+=array[i];
            if(sum==0&&check(array,last,i)){
                list.add(i+1);
                last=i+1;
            }
        }
        if(!check(array, last, n-1)){
            list.clear();
        }
        if(list.size()<=1)
            System.out.println(-1);
        else{
            System.out.println(list.size()-1);
            for(int i=1;i<list.size();i++){
                System.out.print((list.get(i)-list.get(i-1))+" ");
            }
            System.out.println();
        }
    } 
}
