import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class EhabAndPrefixMex {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        int[]array = new int [n];
        StringTokenizer t = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; i ++)
            array[i] = Integer.parseInt(t.nextToken());
        
        HashSet <Integer> set = new HashSet<>();

        for(int i : array)
            set.add(i);
        
        int[]sol = new int[n];
        Arrays.fill(sol, -1);
        for(int i = 1; i < n; i++)
            if(array[i] != array[i - 1])
                sol[i] = array[i - 1];

        int current = 0;

        for(int i = 0; i < n; i++)
        if(sol [i] == -1){
            while(set.contains(current))
                current++;
            sol[i] = current;
            current++;
        }

        StringBuilder b = new StringBuilder();
        for(int i : sol){
            b.append(i);
            b.append(" ");
        }
        System.out.println(b);

        
    }
        
}
