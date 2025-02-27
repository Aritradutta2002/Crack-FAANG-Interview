import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class AdjacencyHatred {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while (t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            ArrayList<Integer> even = new ArrayList<>(), odd = new ArrayList<>();
            for(int i = 0; i < n; i ++){
                int num = Integer.parseInt(t.nextToken());
                if(num % 2 == 0)
                    even.add(num);
                else
                    odd.add(num);
            }
            if(odd.isEmpty() || even.isEmpty())
                System.out.println(-1);
            else{
                StringBuilder b = new StringBuilder();
                for (int i : even)
                    b.append(i + " ");
                for(int i : odd)
                    b.append(i + " ");
                System.out.println(b);
            }
        }
    }
        
}
