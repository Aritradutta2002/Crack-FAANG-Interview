import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.StringTokenizer;

 class TicTacToe {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int[][]arr = new int[3][3];
            // boolean b = false;
            int x = 0, y = 0;
            for(int i = 0; i < 3; i ++){
                String s = r.readLine();
                // if(s.length()!= 3)
                //     b = true;
                for(int j = 0; j < 3; j++){
                    if(s.charAt(j) == 'X'){
                        arr[i][j] = 1;
                        x++;
                    }
                    else if(s.charAt(j) == 'O'){
                        arr[i][j] = 2;
                        y++;
                    }
                }
            }
            // System.out.println(x+ " " + y);
            if(Math.abs(x - y) > 1 || x < y){
                System.out.println(3);
                continue;
            }

            int xv = 0;
            int yv = 0;

            for(int i = 0; i < 3; i ++){
                if(arr[i][1] == arr[i][2] && arr[i][0] == arr[i][1] && arr[i][1] == 1)
                    xv++;
                if(arr[i][1] == arr[i][2] && arr[i][0] == arr[i][1] && arr[i][1] == 2)
                    yv++;
            }

            for(int i = 0; i < 3; i ++){
                if(arr[1][i] == arr[2][i] && arr[0][i] == arr[1][i] && arr[1][i] == 1)
                    xv++;
                if(arr[1][i] == arr[2][i] && arr[0][i] == arr[1][i] && arr[1][i] == 2)
                    yv++;
            }

            if(arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]){
                if(arr[1][1] == 1)
                    xv++;
                else if(arr[1][1] == 2)
                    yv++;
            }

            if(arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]){
                if(arr[1][1] == 1)
                    xv++;
                else if(arr[1][1] == 2)
                    yv++;
            }
            // System.out.println(xv + " " + yv);
            if(xv > 0 && yv > 0){
                System.out.println(3);
            }
            else if(x + y == 9 && xv == 0 && yv == 0)
                System.out.println(1);
            else if(xv == 0 && yv == 0)
                System.out.println(2);
            else{
                if(xv > 0 && x - y != 1)
                    System.out.println(3);
                else if(yv > 0 && x - y != 0)
                    System.out.println(3);
                else
                    System.out.println(1);
            }
        }
    }
        
}
