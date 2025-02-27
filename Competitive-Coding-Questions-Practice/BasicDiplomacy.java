import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BasicDiplomacy {
    static class Day {
        int n;
        int[]array;
        int count;
        Day(int n, int count){
            array = new int[n];
            this.n = n;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            StringTokenizer t = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(t.nextToken());
            int m = Integer.parseInt(t.nextToken());
            int[]count = new int[n];
            Arrays.fill(count, (int)Math.ceil(((double)m) / 2.0));
            Day[]days = new Day[m];
            for(int i = 0; i < m; i ++){
                t = new StringTokenizer(r.readLine());
                int size = Integer.parseInt(t.nextToken());
                days[i] = new Day(size, i);
                for(int j = 0; j < size; j ++)
                    days[i].array[j] = Integer.parseInt(t.nextToken());

            }

            Arrays.sort(days, (a,b) -> {
                return Integer.compare(a.n, b.n);
            });

            boolean p = true;
            int[]ans = new int[m];
            for(Day d : days){
                int pos = -1;
                for(int i : d.array)
                    if(count[i - 1] > 0){
                        pos = i - 1;
                        break;
                    }
                if(pos == -1)
                    p = false;
                else{
                    ans[d.count] = pos + 1;
                    count[pos]--;
                }
            }
            if(!p)
                System.out.println("NO");
            else{
                System.out.println("YES");
                StringBuilder b = new StringBuilder();
                for(int i : ans){
                    b.append(i);
                    b.append(" ");
                }
                System.out.println(b);
            }
        }
    }
        
}
