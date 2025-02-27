import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class PoweSequence {
    static int getCount(int[]array,int n,int k){
        long num=1;
        int sum=0;
        for(int i:array){
            sum+=Math.abs(i-num);
            num*=k;
        }
        if(sum<0)
            return Integer.MAX_VALUE;
        return sum;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        String[]data=r.readLine().split(" ");
        int[]array=new int[n];
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(data[i]);
        Arrays.sort(array);
        int last=Integer.MAX_VALUE;
        for(int i=0;i<Integer.MAX_VALUE;i++){
            int ans=getCount(array, n, i);
            if(ans>last)
                break;
            last=ans;
        }
        System.out.println(last);
    } 
}