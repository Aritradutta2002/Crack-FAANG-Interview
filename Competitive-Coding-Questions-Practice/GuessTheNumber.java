import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class GuessTheNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            for(long i = 1; i <= 1001; i ++){
                long sq = (long)Math.pow(i, 2);
                System.out.println(sq);
                System.out.flush();
                int a = Integer.parseInt(r.readLine());
                if(a == 1)
                    break;
                else if(a == -1)
                    return;
            }
        }
    }
        
}
