import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class RankCollection {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]data1=r.readLine().split(" ");
            int n=Integer.parseInt(data1[0]);
            int k=Integer.parseInt(data1[1]);
            String[]data=r.readLine().split(" ");
            ArrayList<Integer>list=new ArrayList<>();
            for(int i=0;i<n;i++)
                list.add(Integer.parseInt(data[i]));
            int ptr=1;
            while(k>0){
                if(!list.contains(ptr))
                    k--;
                if(k>0)
                    ptr++;
            }
            if(list.contains(ptr+1))
                ptr++;
            System.out.println(ptr);
                
        
         
        }
    } 
}