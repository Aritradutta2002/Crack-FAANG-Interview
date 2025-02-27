import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class AddingPowers {
    static boolean isPossible(int[]array,int n,int k){
        ArrayList <Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int count=0;
            System.out.println(list);
            if(array[i]==0) continue;
            while(array[i]>k){
                array[i]=array[i]/k+array[i]%k;
            }
            if(array[i]==1||array[i]==0){
                if(list.contains(count))
                    return false;
                else
                    list.add(count);
                if(array[i]==1)
                    if(list.contains(count-1))
                        return false;
                    else
                        list.add(count-1);
            }
            else return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]a=r.readLine().split(" ");
            int n=Integer.parseInt(a[0]);
            int k=Integer.parseInt(a[1]);
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            if(isPossible(array, n, k))
                System.out.println("Yes");
            else
                System.out.println("No");

        } 
    } 
}