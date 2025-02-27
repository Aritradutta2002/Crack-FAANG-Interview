import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 class ChefinaAmdSwapTest {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String []data=r.readLine().split(" ");
            int[]array=new int [n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            int min=n;
            int max=1;
            for(int i=0;i<n;i++){
                int count=1;
                for(int j=i+1;j<n;j++)
                    if(array[j]<array[i])
                        count++;
                for(int j=0;j<i;j++)
                    if(array[j]>array[i])
                        count++;
                min=Math.min(min, count);
                max=Math.max(max, count);
            }
            System.out.println(min+" "+max);
        }
    } 
}