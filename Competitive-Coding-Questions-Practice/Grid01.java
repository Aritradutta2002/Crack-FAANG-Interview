import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Grid01 {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while( t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int k = Integer.parseInt(t.nextToken());

            int[][]array = new int[n][n];

            for(int i = 0; i < n; i ++){
                for(int j = 0; j < n - i; j ++){
                    if(k -- >0)
                        array[j][i + j] = 1;
                }
                
                if(i == 0)
                    continue;

                for(int j = 0; j < n - i; j ++){
                    // System.out.println("ss");
                    if(k -- >0)
                        array[j + i][j] = 1;
                }
            }

            long minr = n, maxr = 0, minc = n, maxc = 0;
            for(int i = 0;i < n; i++){
                int sum = 0;
                for(int j = 0; j < n; j++)
                    sum += array[i][j];
                minr = Math.min(minr, sum);
                maxr = Math.max(maxr, sum);
            }
            for(int i = 0;i < n; i++){
                int sum = 0;
                for(int j = 0; j < n; j++)
                    sum += array[j][i];
                minc = Math.min(minc, sum);
                maxc = Math.max(maxc, sum);
            }

            long val = (long) (Math.pow(maxc - minc, 2) + Math.pow(maxr - minr, 2));
            System.out.println(val);

            for(int [] i : array){
                for(int j : i)
                    System.out.print(j);
                System.out.println();
            }
        } 
    } 
}