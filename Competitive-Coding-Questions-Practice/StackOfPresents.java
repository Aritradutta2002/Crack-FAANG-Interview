import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
public class StackOfPresents {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(r.readLine());
        while(t-->0){
            String[]d=r.readLine().split(" ");
            int n=Integer.parseInt(d[0]);
            int m=Integer.parseInt(d[1]);
            String[]data1=r.readLine().split(" ");
            String[]data2=r.readLine().split(" ");
            int[]gifts=new int[n];
            int[]list=new int[m];
            for(int i=0;i<n;i++)
                gifts[i]=Integer.parseInt(data1[i]);
            for(int i=0;i<m;i++)
                list[i]=Integer.parseInt(data2[i]);
            HashSet<Integer> visited=new HashSet<>();
            long count=0;
            int ptr=0;
            for(int i=0;i<m;i++){
                int find=list[i];
                if(visited.contains(find)){
                    count++;
                    continue;
                }
                while(true){
                    if(gifts[ptr]==find){
                        count+=2*(ptr-i)+1;
                        ptr++;
                        break;
                    }
                    else
                        visited.add(gifts[ptr]);
                    ptr++;
                }
            }
            System.out.println(count);

        } 
    } 
}
