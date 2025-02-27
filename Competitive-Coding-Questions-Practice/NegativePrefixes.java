import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class NegativePrefixes {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String []data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            String[]mutable=r.readLine().split(" ");
            ArrayList<Integer>list=new ArrayList<>();
            for(int i=0;i<n;i++)
                if(mutable[i].equals("0"))
                    list.add(array[i]);
            Collections.sort(list);
            int ptr=list.size()-1;
            for(int i=0;i<n;i++)
                if(mutable[i].equals("1"))
                    System.out.print(array[i]+" ");
                else{
                    System.out.print(list.get(ptr)+" ");
                    ptr--;
                }
            System.out.println();
        }
    } 
}
