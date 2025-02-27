import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RestoringThePermutation {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            int n = Integer.parseInt(r.readLine());
            StringTokenizer t = new StringTokenizer(r.readLine());
            int[]array = new int[n];
            for(int i = 0; i < n ;i ++)
                array[i] = Integer.parseInt(t.nextToken());

            int[]max = new int[n], min = new int[n];
            int []visited = new int[n + 1];
            max[0] = array[0];
            min[0] = array[0];
            visited[array[0]] = -1;
            for(int i = 1; i < n; i ++){
                if(array[i] != array[i - 1]){
                    max[i] = array[i];
                    min[i] = array[i];
                    visited[array[i]] = -1;
                }
            }

            int ptr = 1;
            for(int i = 0; i < n; i ++){
                if(min[i] != 0)
                    continue;
                while(visited[ptr] == -1)
                    ptr++;
                if(min[i] == 0)
                    min[i] = ptr++;
            }
    
            ptr = 0;
            for(int i = 0; i < n; i ++){
                if(max[i] != 0)
                    ptr = max[i] - 1;
                else{
                    int p = ptr; 
                    while(visited[ptr] != 0){
                        while(visited[ptr] == -1)
                        ptr--;
                        if(visited[ptr] != 0)
                            ptr = visited[ptr] - 1;
                    }
                    visited[ptr] = -1;
                    max[i] = ptr;
                    visited[p + 1] = ptr;
                }
            }

            StringBuilder b = new StringBuilder();
            for(int i : min){
                b.append(i);
                b.append(" ");
            }
            System.out.println(b);
            b = new StringBuilder();
            for(int i : max){
                b.append(i);
                b.append(" ");
            }
            System.out.println(b);
        }
    }

}
