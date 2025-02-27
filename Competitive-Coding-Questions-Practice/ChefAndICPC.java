import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 class ChefAndICPC {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(t.nextToken());
        long m = Long.parseLong(t.nextToken());
        int q = Integer.parseInt(t.nextToken());
        int count  = 0;
        for(int i = 0; i < n; i++){
            t = new StringTokenizer(r.readLine());
            long sum = 0;
            for(int j = 0; j < q; j++)
                sum += Integer.parseInt(t.nextToken());
            if(sum >= m && Integer.parseInt(t.nextToken()) <= 10)
                count++;
        }
        System.out.println(count);
    }
        
}
