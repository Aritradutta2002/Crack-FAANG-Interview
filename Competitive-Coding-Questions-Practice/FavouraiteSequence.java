import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FavouraiteSequence {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            int[]ans = new int[n];
            for(int i = 0; i < n; i++)
                array[i] = Integer.parseInt(t.nextToken());
            int ptr1 = 0 , ptr2 = n - 1, ptrans = 0;
            boolean c = true;
            while(ptr1 <= ptr2){
                if(c)
                    ans[ptrans++] = array[ptr1 ++];
                else
                    ans[ptrans++] = array[ptr2 --];
                c = !c;    
            }
            StringBuilder b = new StringBuilder();
            for(int i : ans){
                b.append(i);
                b.append(" ");
            }
            System.out.println(b);

        }
    }
        
}
