import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RestaurantCustomers {
    public static void main(String[]args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        int []start = new int[n];
        int []end = new int[n];

        for(int i = 0; i < n; i++){
            StringTokenizer t = new StringTokenizer(r.readLine());
            start[i] = Integer.parseInt(t.nextToken());
            end[i] = Integer.parseInt(t.nextToken());
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int ptr1 = 0, ptr2 = 0, max = 0, current = 0;
        while(ptr1 < n && ptr2 < n){
            if(start[ptr1] < end[ptr2]){
                current++;
                ptr1++;
            }
            else{
                current--;
                ptr2++;
            }
            max = Math.max(max, current);
        }
        
        System.out.println(max);

        


    }    
}
