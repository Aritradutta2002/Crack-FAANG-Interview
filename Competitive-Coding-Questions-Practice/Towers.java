import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Towers {
    static int binarySearch(int[]array , int start , int end , int x){
        end--;
        int ans = end;
        while(start <= end ){
            int mid = start + (end - start) / 2;
            if(array[mid] > x){
                ans = mid;
                end = mid - 1;
            } else 
                start = mid + 1;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(r.readLine());
        StringTokenizer t = new StringTokenizer(r.readLine());
        int[]array = new int[n];
        for(int i = 0; i < n; i++)
            array[i] = Integer.parseInt(t.nextToken());
        
        int[]towers = new int[n];
        towers[0] = array[0];
        int ptr = 1;
        for(int i = 1; i < n; i++){
            int num = array[i];
            if(towers[ptr-1] > num){
                int pos = binarySearch(towers, 0, ptr, num);
                towers[pos] = num;
            } else 
                towers[ptr++] = num;
        }
        System.out.println(ptr);
 
    }
        
}