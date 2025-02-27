import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
public class SpecialElements {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            int n=Integer.parseInt(r.readLine());
            String[]data=r.readLine().split(" ");
            int[]array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=Integer.parseInt(data[i]);
            data=null;
            HashSet<Integer>set=new HashSet<>();
            int sum=0;
            set.add(sum);
            for(int i:array){
                sum+=i;
                set.add(sum);
            }
            int count=0;
            System.out.println(set);
            for(int i:array){
                for(int j:set)
                    if(set.contains(j+i)||set.contains(j-i)){
                        count++;
                        break;
                    }
            }
            System.out.println(count);
        } 
    }     
}
