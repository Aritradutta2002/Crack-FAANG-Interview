import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MinimalHeightTree {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1-->0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int [n];
            for(int i = 0; i < n; i++)
                array[i] = Integer.parseInt(t.nextToken());
            
            int i = 1;
            ArrayList<Integer>list = new ArrayList<>();
            while(i < n){
                int j = i + 1;
                while(j < n)
                    if(array[j] > array [j-1])    
                        j++;
                    else
                        break;
                list.add(j - i);
                i = j;
            }
            int last = 1;
            int height = 0;
            int ptr = 0;
            int size = list.size();
            // System.out.println(list);
            while(ptr < size){
                int temp = 0;
                height++;
                for(i = 0;i < last&& ptr < size;i++)
                    temp+=list.get(ptr++);
                last = temp;
            }
            System.out.println(height);


        }
    }
        
}
