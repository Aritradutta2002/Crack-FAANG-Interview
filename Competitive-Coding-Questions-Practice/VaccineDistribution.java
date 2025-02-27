import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class VaccineDistribution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int d = Integer.parseInt(t.nextToken());
            int c1 = 0, c2 = 0;
            t = new StringTokenizer(r.readLine());
            for(int i = 0; i < n; i++){
                int num = Integer.parseInt(t.nextToken());
                if(num < 80 && num > 9) 
                    c1 ++;
                else    
                    c2 ++;
            }
            int sum = c1 / d ;
            sum += (c1 % d == 0) ? 0 : 1;
            sum += c2 / d ;
            sum += (c2 % d == 0) ? 0 : 1;
            System.out.println(sum);
        }
    }
        
}
