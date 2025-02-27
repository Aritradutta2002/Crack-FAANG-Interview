import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Fence {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            StringTokenizer t1=new StringTokenizer(r.readLine());
            int[]array=new int[3];
            for(int i=0;i<3;i++)
                array[i]=Integer.parseInt(t1.nextToken());
            Arrays.sort(array);
            int n=array[2]-array[1]-array[0];
            System.out.println(Math.max(n, array[2]+1));
        }
    } 
}
