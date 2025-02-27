import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ConstructingArray {
    static boolean getArray(int[]array,int start,int end,int count){
        if(start>end)
            return false;
        int mid=start+(end-start)/2;
        array[mid]=count;
        if((end-start)%2==0){
            boolean b=getArray(array, start, mid-1, count+1);
            if(b)
                getArray(array, mid+1, end, count+2);
            else
                getArray(array, mid+1, end, count+1);
        }
        else{
            boolean b=getArray(array, mid+1, end, count+1);
            if(b)
                getArray(array, start, mid-1, count+2);
            else
                getArray(array, start, mid-1, count+1);
        }

        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            int[]array=new int[n];
            getArray(array, 0, n-1, 1);
            for(int i:array)
                System.out.print(i+" ");
            System.out.println();
        } 
    } 
}
