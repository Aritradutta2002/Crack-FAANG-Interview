import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArrayDestruction {
    static int getPos(int[]array, int end, boolean[]visited, int num, int sum){
        for(int i = 0; i < end; i++)
            if(!visited[i] && num + array[i] == sum){
                return i;
            }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine()) * 2;
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n; i ++)
                array[i] = Integer.parseInt(t.nextToken());
            
            Arrays.sort(array);

            boolean f = false;

            for(int i = 0; i < n - 1; i++){
                boolean [] visited = new boolean[n];
                visited[i] = true;
                visited[ n - 1] = true;
                ArrayList<Integer>list = new ArrayList<>();
                int sum = array[n - 1];
                list.add(sum);
                list.add(array[i]);

                boolean found = true;
                for(int j = n - 2; j >= 0;j --){
                    if(visited[j])
                        continue;
                    visited[j] = true;
                    int pos = getPos(array, n, visited, array[j], sum);
                    if(pos == -1){
                        found = false;
                        break;
                    }
                    list.add(array[j]);
                    list.add(array[pos]);
                    visited[pos] = true;
                    sum = array[j];
                }

                if(found){
                    f = true;
                    System.out.println("YES");
                    System.out.println((list.get(0) + list.get(1)));
                    for(int j = 0; j < n; j += 2)
                        System.out.println((list.get(j)) + " " + list.get(j + 1));
                    break;
                }


                

            }
            if(!f)
                System.out.println("NO");

        }
    }
        
}
