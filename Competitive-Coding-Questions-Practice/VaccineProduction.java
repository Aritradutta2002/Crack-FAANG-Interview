import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class VaccineProduction {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(r.readLine());
        int d1 = Integer.parseInt(t.nextToken());
        int v1 = Integer.parseInt(t.nextToken());
        int d2 = Integer.parseInt(t.nextToken());
        int v2 = Integer.parseInt(t.nextToken());
        int day = 1;
        int total = 0;
        int p = Integer.parseInt(t.nextToken());
        while(total < p){
            if(day >= d1)
                total += v1;
            if(day >= d2)
                total += v2;
            if(total >= p)
                break;
            day++;
        }
        System.out.println(day);

    }
        
}
