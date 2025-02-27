import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
class ChefAndWay {
    static long[]memory;
    static long getMinimum(int[]array,int k,int pos){
        if(pos<0)
            return -1;
        if(pos==0)
            return array[0];
        if(memory[pos]!=-1)
            return memory[pos];
        long min=Long.MAX_VALUE;
        for(int i=1;i<=k;i++){
            long num=getMinimum(array, k, pos-i);
            if(num!=-1)
                min=Long.min(array[pos]*num, min);
        }
        return memory[pos]=min%1000000007;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String []data1=r.readLine().split(" ");
        int n=Integer.parseInt(data1[0]);
        int k=Integer.parseInt(data1[1]);
        String[]data=r.readLine().split(" ");
        int[]array=new int[n];
        for(int i=0;i<n;i++)
            array[i]=Integer.parseInt(data[i]);
        memory=new long[n+1];
        Arrays.fill(memory, -1);
        System.out.println(getMinimum(array, k, n-1));
        
    } 
}