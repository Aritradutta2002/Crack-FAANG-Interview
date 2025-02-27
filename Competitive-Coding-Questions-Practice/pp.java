import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class pp{
    static long maximumSum(int[]array, int size){
        long s1 = 0, s2 = 0;
        for(int i = 0 ; i < size; i ++)
            if(i % 2 == 0)
                s1 += array[i];
            else
                s2 += array[i];
        return Math.max(s1, s2);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        if(n < 0){
            System.out.println("Invalid array size");
            return;
        }
        int []array = new int[n];
        for(int i = 0; i < n; i ++){
            array[i] = Integer.parseInt(r.readLine());
            if(array[i] < 0){
                System.out.println("Invalid input");
                return;
            }
        }

        System.out.println(maximumSum(array, n));


    }
    
}