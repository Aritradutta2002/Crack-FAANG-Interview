import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class OddEvenSubsequence {
    static boolean check(int k,int[]array,int max,int n){
        int even=0,odd=0;
        for(int i=0;i<n;i+=2)
            if(array[i]>max){
                even++;
                i--;
            }
        for(int i=1;i<n;i+=2)
            if(array[i]>max){
                odd++;
                i--;
            }
        return k>=Math.min(even, odd);
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String[]data1=r.readLine().split(" ");
        int n=Integer.parseInt(data1[0]);
        int k=Integer.parseInt(data1[1]);
        String[]data=r.readLine().split(" ");
        int[]array=new int[n];
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(data[i]);
        int min=0;
        int max= (int) (1e9 + 5);
        int ans=max;
        while(max>=min){
            int mid=min+(max-min)/2;
            if(check(n-k, array, mid, n)){
                ans=mid;
                max=mid-1;
            }
            else
                min=mid+1;
        }
        System.out.println(ans);
    } 
}