import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.StringTokenizer;

public class AlmostRectangle {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            boolean [][]arr = new boolean[n][n];
            int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
            boolean bb = false;
            for(int i = 0; i < n; i ++){
                String s = r.readLine();
                for(int j = 0; j < n; j ++){
                    arr[i][j] = s.charAt(j) == '*';
                    if(arr[i][j]){
                        if(!bb){
                            x1 = i;
                            y1 = j;
                            bb= true;
                        } else {
                            x2 = i;
                            y2 = j;
                        }
                    }
                }
            }
            
            if(x1 == x2){
                if(x1 == 0)
                    arr[x1 + 1][y1] = arr[x1 + 1][y2] = true;
                else 
                    arr[x1 - 1][y1] = arr[x1 - 1][y2] = true;
            }
            else if(y1 == y2){
                if(y1 == 0)
                    arr[x1][y1 + 1] = arr[x2][y2 + 1] = true;
                else
                    arr[x1][y1 - 1] = arr[x2][y2 - 1] = true;
            }
            else
                arr[x1][y2] = arr[x2][y1] = true;

            for(int i = 0; i < n; i ++){
                StringBuilder b = new StringBuilder();
                for(int j = 0 ;j < n; j ++){
                    char c = (arr[i][j]) ? '*' : '.';
                    b.append(c);
                }
                System.out.println(b);

            }
        }
    }
        
}
