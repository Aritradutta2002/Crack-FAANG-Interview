import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.StringB;

public class NotAdjacentMatrix {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            int[][]arr = new int[n][n];
            int c = 1;
            for(int i = 0; i < n ;i ++){
                for(int j = 0; j < n; j ++){
                    arr[i][j] = c++;
                }
            }

            for(int i = 0; i < n; i ++){
                for(int j = i % 2; j + 1 < n; j += 2){
                    int temp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = temp;
                }
            }
            for(int []i : arr){
                StringBuilder b = new StringBuilder();
                for(int j : i){
                    b.append(j);
                    b.append(" ");
                }
                System.out.println(b);
            }

        }
    }
        
}
