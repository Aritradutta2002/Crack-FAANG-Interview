import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheRobot {
    static int getPos(int num, int n){
        return n + num + 2;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            String s = r.readLine().trim();
            int n = s.length();
            int[][]array = new int[2 * n + 5][2 * n + 5];
            int x = 0, y = 0;
            for(char c : s.toCharArray()){
                if(c == 'R')
                    x++;
                else if(c == 'L')
                    x--;
                else if(c == 'U')
                    y++;
                else
                    y--;
                
            }
            if(x != 0 && y != 0){
                System.out.println("0 0");
                continue;
            } 

            int ansx = Integer.MAX_VALUE;
            int ansy = Integer.MAX_VALUE;
                

            if(y > 0){
                int mx = 0;
                int my = 0;
                for(char c : s.toCharArray())
                    if(c == 'R')
                        mx++;
                    else if(c == 'L')
                        mx--;
                    else if(c == 'U'){
                        my++;
                        array[getPos(mx, n)][getPos(my, n)]++;
                    }
                    else
                        my--;
                for(int i =  - n; i <= n; i++){
                    int it = getPos(i, n);
                    int sum = 0;
                    int j = -n;
                    while(sum < Math.abs(y)){
                        sum +=array[it][getPos(j, n)];
                        j++;
                    }
                    if(sum == Math.abs(y)){
                        ansx = i;
                        ansy = j;
                        break;
                    }
                }

            }

            if(y < 0){
                int mx = 0;
                int my = 0;
                for(char c : s.toCharArray())
                    if(c == 'R')
                        mx++;
                    else if(c == 'L')
                        mx--;
                    else if(c == 'U'){
                        my++;
                    }
                    else{
                        my--;
                        array[getPos(mx, n)][getPos(my, n)]++;
                    }
                for(int i =  - n; i <= n; i++){
                    int it = getPos(i, n);
                    int sum = 0;
                    int j = n;
                    while(sum < Math.abs(y)){
                        sum +=array[it][getPos(j, n)];
                        j--;
                    }
                    if(sum == Math.abs(y)){
                        ansx = i;
                        ansy = j;
                        break;
                    }
                }

            }

            if(x > 0){
                int mx = 0;
                int my = 0;
                for(char c : s.toCharArray())
                    if(c == 'R'){
                        mx++;
                        array[getPos(mx, n)][getPos(my, n)]++;
                    }
                    else if(c == 'L')
                        mx--;
                    else if(c == 'U'){
                        my++;
                    }
                    else
                        my--;
                for(int j =  - n; j <= n; j++){
                    int jt = getPos(j, n);
                    int sum = 0;
                    int i = -n;
                    while(sum < Math.abs(x)){
                        sum +=array[getPos(i, n)][jt];
                        i++;
                    }
                    if(sum == Math.abs(x)){
                        ansx = i;
                        ansy = j;
                        break;
                    }
                }

            }

            if(x < 0){
                int mx = 0;
                int my = 0;
                for(char c : s.toCharArray())
                    if(c == 'R'){
                        mx++;
                        
                    }
                    else if(c == 'L'){
                        mx--;
                        array[getPos(mx, n)][getPos(my, n)]++;
                    }
                    else if(c == 'U'){
                        my++;
                    }
                    else
                        my--;
                for(int j =  - n; j <= n; j++){
                    int jt = getPos(j, n);
                    int sum = 0;
                    int i = n;
                    while(sum < Math.abs(x)){
                        sum +=array[getPos(i, n)][jt];
                        i--;
                    }
                    if(sum == Math.abs(x)){
                        ansx = i;
                        ansy = j;
                        break;
                    }
                }

            }

            if(ansx == Integer.MAX_VALUE)
                System.out.println("0 0");
            else
                System.out.println(ansx + " " + ansy);
        }
    }
        
}
