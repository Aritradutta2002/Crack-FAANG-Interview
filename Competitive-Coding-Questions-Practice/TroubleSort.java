import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class TroubleSort {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            String[]types=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            int c1=0;int c2=0;
            boolean containsAll=false;
            for(String s:types){
                if(s.equals("1"))
                    c1++;
                else
                    c2++;
                if(c1>0&&c2>0){
                    containsAll=true;
                    break;
                }
            }
            int[]cpy=new int[n];
            for(int i=0;i<n;i++)
                cpy[i]=array[i];
            Arrays.sort(cpy);
            boolean isSorted=true;
            for(int i=0;i<n;i++)
                if(array[i]!=cpy[i]){
                    isSorted=false;
                    break;
                }
            // System.out.println(isSorted+" "+);
            if(isSorted||containsAll)
                System.out.println("YES");
            else
                System.out.println("NO");

        } 
    } 
}
