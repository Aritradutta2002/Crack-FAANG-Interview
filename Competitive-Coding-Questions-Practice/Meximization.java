import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Meximization {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n; i ++)
                array[i] = Integer.parseInt(t.nextToken());
            Arrays.sort(array);
            ArrayList<Integer>list = new ArrayList<>();
            System.out.print(array[0]+" ");
            for(int i = 1; i < n; i ++ )
                if(array[i] == array[i - 1])
                    list.add(array[i]);
                else
                    System.out.print(array[i] + " ");
            for(int i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }
        
}
