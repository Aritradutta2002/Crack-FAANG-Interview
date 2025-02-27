import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BoatCompetion {
    static int getCount(int[]array,int sum){
        int start=0,end=array.length-1;
        int count=0;
        while(start<end){
            int num1=array[start],num2=array[end];
            if(num1+num2>sum)
                end--;
            else if(num1+num2<sum)
                start++;
            else{
                count++;
                end--;
                start++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String []data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++){
                array[i]=Integer.parseInt(data[i]);
            }
            Arrays.sort(array);
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int i:array){
                min=Integer.min(i, min);
                max=Integer.max(i, max);
            }
            int ans=Integer.MIN_VALUE;
            for(int i=min*2;i<=max*2;i++){
                ans=Integer.max(ans,getCount(array, i) );
            }
            System.out.println(ans);
        }
    }
}