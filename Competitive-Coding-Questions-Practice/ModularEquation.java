import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 class ModularEquation {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int m = Integer.parseInt(t.nextToken());
            long c = 0;
            for(int b = 2 ; b <= n; b++){
                int val = m - m % b;
                for(int a = 1; a <= Math.sqrt(val); a++){
                    if(val % a == 0){
                        if(a < b)
                            c++;
                        if(val / a != a && val / a < b){
                            c += 1;
                            // System.out.println(b / a + " " + b);
                        }
                    }
                }
            }
            System.out.println(c);
        }
    }
        
}
