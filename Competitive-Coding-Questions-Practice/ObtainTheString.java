import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ObtainTheString {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());
        while(t1 -- > 0){
            String s = r.readLine().trim();
            String z = r.readLine().trim();
            int n = s.length();
            int[][]array = new int[n + 1][26];
            for(int [] i : array)
                Arrays.fill(i, -1);
            for(int i = n - 1; i >= 0; i --){
                int last = (i + 1) % n;
                for(int j = 0; j  < 26; j ++)
                    array[i][j] = array[last][j];
                array[i][s.charAt(last) - 'a'] = last;
            }
            for(int i = n; i >= 0; i --){
                int last = (i + 1) % n;
                for(int j = 0; j  < 26; j ++)
                    array[i][j] = array[last][j];
                array[i][s.charAt(last) - 'a'] = last;
            }

            // for(int[]i : array){
            //     for(int k : i)
            //         System.out.print(k + " ");
            //     System.out.println();
            // }
            boolean start = true;
            int count = 0, ptr = 0;
            for(char c : z.toCharArray()){
                if(start){
                    count ++;
                    start = false;
                }
                if(s.charAt(ptr) == c){
                    ptr = (ptr + 1) % n;
                    if(ptr == 0)
                        start = true;
                    continue;
                }
                int next = array[ptr][c - 'a'];
                if(next == -1){
                    count = -1;
                    break;
                }
                if((next + 1) % n < next + 1)
                    start = true;
                ptr = (next + 1) % n;
            }
            if(start&&count != -1)
                count++;
            System.out.println(count);



        }
    }
        
}
