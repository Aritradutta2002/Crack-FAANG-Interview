import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Triangles {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            int[][]array = new int[n][n];
            for(int i = 0; i < n; i++){
                String s = r.readLine();
                for(int j = 0; j < n; j++)
                    array[i][j] = Integer.parseInt(Character.toString(s.charAt(j)));
            }

            int[]xmax = new int[10];
            int[]xmin = new int[10];
            int[]ymax = new int[10];
            int[]ymin = new int[10];
            Arrays.fill(xmax, Integer.MIN_VALUE);
            Arrays.fill(xmin, Integer.MAX_VALUE);
            Arrays.fill(ymax, Integer.MIN_VALUE);
            Arrays.fill(ymin, Integer.MAX_VALUE);

            for(int x = 0 ; x < n; x++)
                for(int y = 0; y < n; y ++){
                    int num=array[x][y];
                    xmax[num]= Math.max(xmax[num], x);
                    xmin[num]= Math.min(xmin[num], x);
                    ymax[num]= Math.max(ymax[num], y);
                    ymin[num]= Math.min(ymin[num], y);
                }

            long []ans = new long[10];

            for(int x = 0; x < n;x++){
                for(int y = 0; y < n; y++){
                    int num = array[x][y];
                    int xd = 0;
                    int yd = 0;
                    if(xmax[num]!=Integer.MIN_VALUE)
                        xd = Math.max(xd, xmax[num] - x);
                    if(xmin[num]!= Integer.MAX_VALUE)
                        xd = Math.max(xd, x - xmin[num]);

                    if(ymax[num]!=Integer.MIN_VALUE)
                        yd = Math.max(yd, ymax[num] - y);
                    if(ymin[num]!= Integer.MAX_VALUE)
                        yd = Math.max(yd, y - ymin[num]);

                    int x2 = Integer.max(x, n - x - 1);
                    int y2 = Integer.max(y, n - y - 1);
                    // System.out.println(x +" "+y +" || "+x2+" "+yd+" || "+xd+" "+y2);
                    ans[num] = Math.max(ans[num], Math.max((long)x2*(long)yd, (long)y2*(long)xd));
                }
            }
            StringBuilder b = new StringBuilder();
            for(long i :ans){
                b.append(i);
                b.append(" ");
            }
            System.out.println(b);


        }
    }
        
}
