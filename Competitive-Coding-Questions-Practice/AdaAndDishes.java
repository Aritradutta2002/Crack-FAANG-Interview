import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 class AdaAndDishes {
    static int getMin(int[]array , int i , int n , int sum1 , int sum2){
        if(i == n-1)
            return Math.min(Math.max(sum1+array[i], sum2),Math.max(sum1, sum2+array[i]));
        return Math.min(getMin(array, i+1, n, sum1+array[i], sum2), getMin(array, i+1, n, sum1, sum2+array[i])); 
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1-->0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int [] array = new int[n];
            for(int i = 0; i < n; i++)
                array[i] = Integer.parseInt(t.nextToken());
            System.out.println(getMin(array, 0, n, 0, 0));

        } 
    } 
}
