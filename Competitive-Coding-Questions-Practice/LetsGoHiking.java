import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LetsGoHiking {
    static int[]getPeak(int[]array, int n , int pos){
        int ptr1 = pos + 1;
        while(ptr1 < n){
            if(array[ptr1] > array[ptr1 - 1])
                break;
            ptr1++;
        }

        int ptr2 = pos - 1;
        while(ptr2 >= 0){
            if(array[ptr2] > array[ptr2 + 1])
                break;
            ptr2--;
        }
        int[]a = {ptr1 - pos - 1, pos - ptr2 - 1};
        return a;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        StringTokenizer t = new StringTokenizer(r.readLine());
        int[]array = new int[n];
        for(int i = 0; i < n; i ++)
            array[i] = Integer.parseInt(t.nextToken());

        int max = 0, maxPos = -1;

        for(int i = 0; i < n;i ++){
            if(i == 0 ||i == n - 1){
                int[]arr = getPeak(array, n, i);
                if(Math.max(arr[0], arr[1]) > max){
                    max = Math.max(arr[0], arr[1]);
                    maxPos = i;
                }
            }
            else if(array[i] > array[i + 1] && array[i] > array[i - 1]){
                int[]arr = getPeak(array, n, i);
                if(Math.max(arr[0], arr[1]) > max){
                    max = Math.max(arr[0], arr[1]);
                    maxPos = i;
                }
            }
        }

        for(int i = 0; i < n ;i ++){
            if(i == n - 1|| i == 0){
                int[]arr = getPeak(array, n, i);
                if(i != maxPos && Math.max(arr[0], arr[1]) == maxPos)
                    maxPos = -1;
            }
            else if(array[i] > array[i + 1] && array[i] > array[i - 1]){
                int[]arr = getPeak(array, n, i);
                if(i != maxPos && Math.max(arr[0], arr[1]) == maxPos)
                    maxPos = -1;
            }
        }
        if(n == 2){
            System.out.println(0);
            return;
        }

        if(maxPos == -1)
            System.out.println(0);
        else{
            int[]arr = getPeak(array, n, maxPos);
            max = Math.max(arr[0], arr[1]);
            int min =  Math.min(arr[0], arr[1]);
            max -= (1 - max % 2);
            if(max >= min)
                System.out.println(0);
            else
                System.out.println(1);
        }
    }
        
}
