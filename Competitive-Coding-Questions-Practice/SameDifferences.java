import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
// import java.util.Arrays;
import java.util.StringTokenizer;

public class SameDifferences {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            ArrayList<Integer>list = new ArrayList<>();
            for(int i = 0; i < n; i ++){
                list.add((Integer.parseInt(t.nextToken()) - i));
            }
            // System.out.println(list);
            Collections.sort(list);
            long c = 0;
            for(int i = 0; i < n; i ++){
                int j;
                for(j = i; j < n; j ++){
                    if(list.get(j) != list.get(i))
                        break;
                }

                long cn = j - i;
                long cc = (cn - 1);
                if(cc % 2 == 0)
                    cc /= 2;
                else
                    cn /= 2;
                c += cn *cc;
                i = j - 1;


            }
            System.out.println(c);

            

        }
    }
        
}
