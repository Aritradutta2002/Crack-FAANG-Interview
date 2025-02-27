import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class playlist2 {
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n; i ++)
                array[i] = Integer.parseInt(t.nextToken());

            int[]next = new int[n];
            for(int i = 0; i < n; i ++)
                next[i] = i + 1;

            next[n - 1] = 0;

            int pos = 0;
            ArrayList<Integer>list = new ArrayList<>();
            int c = 0;
            boolean nn = false;

            while(true){
                int posN = next[pos];
                if(gcd(array[pos], array[posN]) == 1){
                    next[pos] = next[posN];
                    c++;
                    list.add(posN + 1);
                }

                if(posN < pos && c == 0)
                    break;
                if(posN < pos)
                    c = 0;
                if(nn)
                    break;
                if(next[pos] == pos){
                    nn = true;
                }
                pos = next[pos];
            }
            n = list.size();
            StringBuilder b = new StringBuilder();
            int last  = -1;
            int cc = 0;
            for(int i: list){
                if(i == last)
                    continue;
                last = i;
                cc++;
                b.append(i);
                b.append(" ");
            }
            System.out.print(cc + " ");
            System.out.println(b);

        }
    }
        
}
