import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class FrogSort {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            int[]mem = new int[n + 1];
            int[]jump = new int[n + 1];
            StringTokenizer t = new StringTokenizer(r.readLine()), t2 = new StringTokenizer(r.readLine());
            
            for(int i = 1; i <= n; i ++){
                int num = Integer.parseInt(t.nextToken());
                mem[num] = i;
                jump[num] = Integer.parseInt(t2.nextToken());
            }

            long max = mem[1], diff = 0;
            for(int i = 2; i <= n; i++){
                int pos = mem[i];
                if(max >= pos){
                    long jumps = (max - pos + 1) / jump[i];
                    jumps += ((max - pos + 1) % jump[i] == 0 ) ? 0 : 1;
                    max = pos + (long)jumps * (long)jump[i];
                    diff += jumps;
                }
                else{
                    max = mem[i];
                }
            }

            System.out.println(diff);
        }
    }
        
}
