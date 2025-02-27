import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HillsAndValleys {
    static int check(int[]array, int n, int pos){
        int c = 0;
        for(int i = Math.max(1, pos - 2); i < Math.min(n - 1, pos + 2); i++)
            if((array[i] > array[i + 1] && array[i] > array[i - 1]) || (array[i] < array[i + 1] && array[i] < array[i - 1]))
                c++;
        return c;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            int[]arr = new int[n];
            StringTokenizer t = new StringTokenizer(r.readLine());
            for(int i = 0; i < n ;i ++)
                arr[i] = Integer.parseInt(t.nextToken());
            int diff = 0;
            int sum = 0;

            for(int i = 1; i < n - 1; i ++)
                if((arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) || (arr[i] < arr[i + 1] && arr[i] < arr[i - 1]))
                    sum++;


            for(int i = 0; i < n; i++){
                int temp = arr[i];
                int c = check(arr, n, i);
                if(i > 0){
                    arr[i] = arr[i - 1];
                    diff = Math.max(diff, c - check(arr, n, i) );
                }
                if(i < n - 1){
                    arr[i] = arr[i + 1];
                    diff = Math.max(diff, c - check(arr, n, i) );
                }
                arr[i] = temp;

            }
            // System.out.println(sum + " " + diff);
            System.out.println(sum - diff);
            
        }
    }
        
}
