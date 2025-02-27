import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinimumTies {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(r.readLine());
            ArrayList<Integer>ans = new ArrayList<>();
            if(n % 2 == 0){
                int []array = new int[n - 2];
                int m = n - 2;
                for(int i = 0; i < m / 2; i ++)
                    array[i] = 1;
                for(int i = m / 2; i < m; i ++)
                    array[i] = -1;

                for(int i = 0; i < n / 2; i ++){
                    ans.add(0);
                    for(int j = 0; j < m; j ++)
                        ans.add(array[j]);
                    for(int j = 0; j < m; j ++)
                        ans.add(array[j]);
                    m -= 2;
                }
                
            } else {
                int[]array = new int[n - 1];
                int m = n - 1;
                for(int i = 0; i < m / 2; i++)
                    array[i] = 1;
                for(int i = m / 2; i < m; i++)
                    array[i] = -1;

                for(int i = 0;i < n - 1; i ++){
                    for(int j = 0; j < m; j ++)
                        ans.add(array[j]);
                    m --;
                }
            }
            StringBuilder b = new StringBuilder();
            for(int i : ans){
                b.append(i);
                b.append(' ');
            }
            System.out.println(b);
        }
        
    }
        
}
