import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
public class Uniqueness {
    static boolean check(int[]array,int n,int k){
        HashSet<Integer>set=new HashSet<>();
        boolean check1=true,check2=true;
        boolean found=false;
        for(int i=0;i<n;i++){
            int num=array[i];
            if(!set.contains(num))
                set.add(num);
            else
                if(!found){
                    found=true;
                    i+=k;
                    i--;
                }
                else{
                    check1=false;
                    break;
                }
        }
        set=new HashSet<>();
        found=false;
        for(int i=n-1;i>=0;i--){
            int num=array[i];
            if(!set.contains(num))
                set.add(num);
            else
                if(!found){
                    found=true;
                    i-=k;
                    i++;
                }
                else{
                    check2=false;
                    break;
                }
        }
        return check1||check2;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        String[]data=r.readLine().split(" ");
        int[]array=new int[n];
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(data[i]);
        int ans=n;
        int max=n;
        int min=0;
        while(max>=min){
            int mid=min+(max-min)/2;
            if(check(array, n, mid)){
                ans=mid;
                max=mid-1;
            }
            else
                min=mid+1;
        }
        System.out.println(ans);
    } 
}
