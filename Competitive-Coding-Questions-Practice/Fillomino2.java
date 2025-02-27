import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fillomino2 {
    static boolean isValid(int x, int y, int n){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        int[][]array = new int[n][n];
        StringTokenizer t = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; i ++){
            array[i][i] = Integer.parseInt(t.nextToken());
        }
        boolean poss = true;
        for(int i = n - 1; i >= 0; i--){
            int posx = i, posy = i; 

            int num = array[i][i];
            for(int j = 0; j < num; j ++){
                if(!isValid(posx, posy, n)){
                    poss = false;
                    break;
                }

                if(array[posx][posy] != 0 && posx != posy){
                    poss = false;
                    break;
                }
                array[posx][posy] = num;
                if(posy + 1 < n){
                    if(array[posx][posy + 1] == 0)
                        posy++;
                    else
                        posx --;
                } else
                    posx --;
            }


        }

        if(!poss)
            System.out.println(-1);
        else{
            
            // for(int tt = 0; tt < n; tt ++){
            //     StringBuilder b = new StringBuilder();
            //     for(int j = 0; j < n; j ++){
            //         b.append(array[tt][j]);
            //         b.append(" ");
            //     }
            //     System.out.println(b);

            // }
            for(int i = 0; i < n; i ++){
                StringBuilder b = new StringBuilder();
                for(int j = 0; j <= i; j ++){
                    b.append(array[j][i]);
                    b.append(" ");
                }
                System.out.println(b);

            }
        }
    }
        
}
